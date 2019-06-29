package org.nick.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "data")
public class Data {

    @Id
    @GeneratedValue
    @XmlTransient
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @XmlElement(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id")
    @XmlElement(name = "service")
    private Service service;

    @XmlElement(name = "procedure")
    private int procedure;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    @XmlElement(name = "authority")
    private Authority authority;

    @XmlElement(name = "date")
    private String date;

    @XmlElement(name = "received-date")
    private String receivedDate;

    @XmlElement(name = "okato")
    private String okato;

    @OneToOne(mappedBy = "data")
    @XmlTransient
    private Form form;

    public Data() {
    }

    @Override
    public String toString() {
        return "Data{" +
                "user=" + user +
                ", service=" + service +
                ", procedure=" + procedure +
                ", authority=" + authority +
                ", date='" + date + '\'' +
                ", receivedDate='" + receivedDate + '\'' +
                ", okato='" + okato + '\'' +
                '}';
    }
}
