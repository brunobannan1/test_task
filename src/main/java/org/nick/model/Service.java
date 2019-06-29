package org.nick.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;


@Entity
@Table(name = "service")
@XmlRootElement(name = "service")
public class Service {
    @Id
    @XmlAttribute(name = "id")
    private int id;
    @XmlValue
    private String service;

    @OneToMany(mappedBy = "service")
    @XmlTransient
    private List<Data> data;

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