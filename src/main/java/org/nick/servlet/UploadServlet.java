package org.nick.servlet;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.nick.app.HibernateConfiguration;
import org.nick.dao.FormsDaoImpl;
import org.nick.dao.FormsDataAsList;
import org.nick.model.*;
import org.nick.view.TemplateUtility;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private Forms forms;
    FormsDaoImpl formsDao = new FormsDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = req.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        String fileName = Paths.get(filePart.getSubmittedFileName()).toString();
        try {
            XMLInputFactory xif = XMLInputFactory.newInstance();
            XMLStreamReader xsr = xif.createXMLStreamReader(fileContent);
            xsr.nextTag();
            while (xsr.hasNext()) {
                if (xsr.isStartElement() && xsr.getLocalName().equals("forms")) {
                    break;
                }
                xsr.next();
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(Forms.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<Forms> forms1 = jaxbUnmarshaller.unmarshal(xsr, Forms.class);
            forms = forms1.getValue();
            System.out.println(forms);
            formsDao.save(forms);
            TemplateEngine te = TemplateUtility.setup();
            Context context = new Context();
            FormsDataAsList formsDataAsList = new FormsDataAsList();
            formsDataAsList.retrieve(forms);
            context.setVariable("dataList", formsDataAsList.getDataList());
            context.setVariable("rateList", formsDataAsList.getRateList());
            req.setCharacterEncoding("UTF-8");
            te.process("UploadDetails", context, resp.getWriter());
            Session session = HibernateConfiguration.openSession();
            session.beginTransaction();
            session.createNativeQuery("UPDATE forms SET success = true, uploaddate = (SELECT current_timestamp) WHERE id = (SELECT max(ID) from forms)").executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            Session session = HibernateConfiguration.openSession();
            session.beginTransaction();
            session.createNativeQuery("INSERT INTO forms (success,uploaddate) values (false,(SELECT current_timestamp))").executeUpdate();
            session.getTransaction().commit();
            session.close();
            resp.sendRedirect("Error.html");
        }
    }
}
