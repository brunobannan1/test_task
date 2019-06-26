package org.nick.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "rates")
public class Rates {
    @XmlElement
    private ArrayList<Rate> rates;

    public Rates() {
    }
}