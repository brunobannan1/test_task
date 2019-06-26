package org.nick.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Form {

    @XmlAttribute(name = "mkgu-id")
    private int mkguId;

    @XmlAttribute(name = "foreign-id")
    private int foreignId;

    @XmlElement(name = "data")
    private Data data;

    @XmlElement(name = "rates")
    private Rates rates;

}
