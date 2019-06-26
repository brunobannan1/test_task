package org.nick.app;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.nick.model.*;

public class Main {
    static Forms forms = null;
    public static void main(String[] args) {
        String filePath="example.xml";
        try {
            XMLInputFactory xif = XMLInputFactory.newInstance();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader(filePath));
            xsr.nextTag();
            while(xsr.hasNext()) {
                if(xsr.isStartElement() && xsr.getLocalName().equals("forms")) {
                    break;
                }
                xsr.next();
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(Forms.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            System.out.println(xsr.getNamespaceContext().getNamespaceURI("ns"));
            JAXBElement<Forms> forms1 = jaxbUnmarshaller.unmarshal(xsr, Forms.class);
            System.out.println(forms1.getName());
            forms = forms1.getValue();
        } catch (JAXBException | FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        System.out.println(forms.toString());
    }
}