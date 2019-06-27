package org.nick.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "service")
public class Service {
    @XmlAttribute(name = "id")
    private int id;
    @XmlValue
    private String service;

    public Service() {
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", service='" + service + '\'' +
                '}';
    }
}