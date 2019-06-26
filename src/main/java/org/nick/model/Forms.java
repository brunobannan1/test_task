package org.nick.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType(name = "forms")
public class Forms {

    @XmlElement(name = "form")
    ArrayList<Form> forms;

    public Forms() {
    }
}
