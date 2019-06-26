package org.nick.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "user")
    private String user;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    public User() {
    }
}
