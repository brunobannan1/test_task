package org.nick.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "rate")
public class Rate {

    @XmlAttribute(name = "indicator-id")
    private int indicatorId;

    @XmlAttribute(name = "value-id")
    private int value;

    @XmlValue
    private int rate;

    @Override
    public String toString() {
        return "Rate{" +
                "indicatorId=" + indicatorId +
                ", value=" + value +
                ", rate=" + rate +
                '}';
    }

    public Rate() {
    }
}
