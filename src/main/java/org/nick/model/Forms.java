package org.nick.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "forms")
public class Forms {

    @XmlElement(name = "form")
    private ArrayList<Form> forms;

    public Forms() {
    }

    @Override
    public String toString() {
        return "Forms{" +
                "forms=" + forms +
                '}';
    }
}
