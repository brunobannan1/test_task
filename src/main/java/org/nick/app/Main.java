package org.nick.app;

import org.hibernate.Session;
import org.nick.model.Forms;
import org.nick.org.nick.dao.FormsDaoImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    static Forms forms = null;

    public static void main(String[] args) {
        String filePath = "example.xml";
        try {
            XMLInputFactory xif = XMLInputFactory.newInstance();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader(filePath));
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
        } catch (JAXBException | FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        Session session = HibernateConfiguration.openSession();

        /*AuthorityDaoImpl authorityDao = new AuthorityDaoImpl();
        Authority a = authorityDao.find(1);
        List ars = authorityDao.findAll();*/
        FormsDaoImpl formsDao = new FormsDaoImpl();
        Forms filledForms = formsDao.fillForms(forms);
        formsDao.save(forms);
        int i = 0;
        session.close();
    }
}