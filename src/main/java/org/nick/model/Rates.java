package org.nick.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

@Entity
@Table(name = "rates")
@XmlRootElement(name = "rates")
public class Rates {
    @Id
    @GeneratedValue
    @XmlTransient
    private int id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "rates_rate",
            joinColumns = {@JoinColumn(name = "rates_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "rate_id", referencedColumnName = "indicator_id")}
    )
    @XmlElement(name = "rate")
    private ArrayList<Rate> rates;

    @OneToOne(mappedBy = "rates")
    @XmlTransient
    private Form form;


    public Rates() {
    }

    @Override
    public String toString() {
        return "Rates{" +
                "rates=" + rates +
                '}';
    }
}