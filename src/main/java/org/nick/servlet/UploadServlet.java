package org.nick.servlet;

import org.nick.model.Forms;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private Forms forms;

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
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("Error.html");
        }
    }
}
