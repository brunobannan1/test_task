package org.nick.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "service")
@XmlRootElement(name = "service")
public class Service {
    @Id
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