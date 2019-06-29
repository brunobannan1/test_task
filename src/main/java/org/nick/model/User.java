package org.nick.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;

@Entity
@Table(name = "xml_user")
@XmlRootElement(name = "user")
public class User {
    @Id
    @XmlAttribute(name = "id")
    private String id;
    @Column(name = "username")
    @XmlValue
    private String user;

    @OneToMany(mappedBy = "user")
    @XmlTransient
    private List<Data> data;

    public User() {
    }

    public User(String id, String user) {
        this.id = id;
        this.user = user;
    }
}
