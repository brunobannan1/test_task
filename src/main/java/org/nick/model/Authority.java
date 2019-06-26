package org.nick.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "authority")
public class Authority {

    @XmlAttribute(name = "id")
    private int id;
    @XmlValue
    private String authority;

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }

    public Authority() {
    }
}
