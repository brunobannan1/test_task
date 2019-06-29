package org.nick.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authority")
@XmlRootElement(name = "authority")
public class Authority {
    @Id
    @XmlAttribute(name = "id")
    private int id;

    @XmlValue
    private String authority;

    @OneToMany(mappedBy = "authority")
    @XmlTransient
    private List<Data> data;

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
