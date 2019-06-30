package org.nick.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @XmlElement(name = "user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", nullable = false)
    @XmlElement(name = "service")
    private Service service;

    @XmlElement(name = "procedure")
    private int procedure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authority_id", nullable = false)
    @XmlElement(name = "authority")
    private Authority authority;

    @XmlElement(name = "date")
    private String date;

    @XmlElement(name = "received-date")
    private String receivedDate;

    @XmlElement(name = "okato")
    private String okato;

    @OneToOne(mappedBy = "data", cascade = CascadeType.ALL)
    @XmlTransient
    private Form form;

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", user=" + user +
                ", service=" + service +
                ", procedure=" + procedure +
                ", authority=" + authority +
                ", date='" + date + '\'' +
                ", receivedDate='" + receivedDate + '\'' +
                ", okato='" + okato + '\'' +
                '}';
    }
}
