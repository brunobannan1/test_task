package org.nick.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@XmlRootElement(name = "rate")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
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
}
