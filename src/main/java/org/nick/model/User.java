package org.nick.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

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

    public User() {
    }

    public User(String id, String user) {
        this.id = id;
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
