package org.nick.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @XmlElement(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @XmlElement(name = "service")
    private Service service;

    @XmlElement(name = "procedure")
    private int procedure;

    @ManyToOne
    @JoinColumn(name = "authority_id", nullable = false)
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
