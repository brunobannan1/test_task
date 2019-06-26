package org.nick.app;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import org.nick.model.*;

public class Main {
    static Forms forms = null;
    public static void main(String[] args) {
        String filePath="test.xml";
        File file = new File(filePath);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Forms.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Forms forms1 = (Forms) jaxbUnmarshaller.unmarshal(file);
            forms = forms1;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(forms.toString());
    }
}