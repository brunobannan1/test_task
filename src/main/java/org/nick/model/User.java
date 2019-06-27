package org.nick.model;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@Entity
@Table(appliesTo = "user")
@XmlRootElement(name = "user")
public class User {
    @XmlAttribute(name = "id")
    private String id;
    @XmlValue
    private String user;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
