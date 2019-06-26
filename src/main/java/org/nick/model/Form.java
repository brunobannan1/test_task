package org.nick.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "form")
public class Form {

    @XmlAttribute(name = "mkgu-id")
    private int mkguId;

    @XmlAttribute(name = "foreign-id")
    private String foreignId;

    @XmlElement(name = "data")
    private Data data;

    @XmlElement(name = "rates")
    private Rates rates;

    @Override
    public String toString() {
        return "Form{" +
                "mkguId=" + mkguId +
                ", foreignId=" + foreignId +
                ", data=" + data +
                ", rates=" + rates +
                '}';
    }
}
