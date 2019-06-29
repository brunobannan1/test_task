package org.nick.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "form")
@XmlRootElement(name = "form")
public class Form {
    @Id
    @Column(name = "id")
    @XmlAttribute(name = "mkgu-id")
    private int mkguId;

    @XmlAttribute(name = "foreign-id")
    private String foreignId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_data_id", referencedColumnName = "id")
    @XmlElement(name = "data")
    private Data data;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_rates_id", referencedColumnName = "id")
    @XmlElement(name = "rates")
    private Rates rates;

    @ManyToOne
    @JoinColumn(name = "forms_id", nullable = false)
    @XmlTransient
    private Forms forms;

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
