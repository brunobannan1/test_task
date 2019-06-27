package org.nick.model;

import javax.persistence.JoinColumn;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class Data {

    @XmlElement(name = "user")
    private User user;
    @XmlElement(name = "service")
    private Service service;
    @XmlElement(name = "procedure")
    private int procedure;

    @JoinColumn(name = "authority_id")
    @XmlElement(name = "authority")
    private Authority authority;
    @XmlElement(name = "date")
    private String date;
    @XmlElement(name = "received-date")
    private String receivedDate;
    @XmlElement(name = "okato")
    private String okato;

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
