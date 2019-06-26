package org.nick.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rate {

    @XmlAttribute(name = "indicator-id")
    private int indicatorId;

    @XmlAttribute(name = "value")
    private int value;

    @XmlElement(name = "rate")
    private int rate;

    public Rate() {
    }
}
