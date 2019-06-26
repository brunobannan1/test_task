package org.nick.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rate")
public class Rate {

    @XmlAttribute(name = "indicator-id")
    private int indicatorId;

    @XmlAttribute(name = "value")
    private int value;

    @XmlElement(name = "rate")
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
