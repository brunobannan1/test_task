package org.nick.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "rates")
public class Rates {
    @XmlElement(name = "rate")
    private ArrayList<Rate> rates;

    @Override
    public String toString() {
        return "Rates{" +
                "rates=" + rates +
                '}';
    }

    public Rates() {

    }
}