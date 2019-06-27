package org.nick.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@Entity
@Table(name = "rates")
@XmlRootElement(name = "rates")
public class Rates {
    @XmlElement(name = "rate")
    private ArrayList<Rate> rates;


    public Rates() {
    }

    @Override
    public String toString() {
        return "Rates{" +
                "rates=" + rates +
                '}';
    }
}