package org.nick.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;

@Entity
@XmlRootElement(name = "rate")
public class Rate {
    @Id
    @Column(name = "indicator_id")
    @XmlAttribute(name = "indicator-id")
    private int indicatorId;

    @XmlAttribute(name = "value-id")
    private int value;

    @XmlValue
    private int rate;

    @ManyToMany(mappedBy = "rates")
    @XmlTransient
    private List<Rates> rates;

    public Rate() {
    }

    @Override
    public String toString() {
        return "Rate{" +
                "indicatorId=" + indicatorId +
                ", value=" + value +
                ", rate=" + rate +
                '}';
    }
}
