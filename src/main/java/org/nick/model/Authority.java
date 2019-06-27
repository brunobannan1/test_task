package org.nick.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "authority")
@XmlRootElement(name = "authority")
public class Authority {

    @Id
    @XmlAttribute(name = "id")
    private int id;
    @XmlValue
    private String authority;

    public Authority() {
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
