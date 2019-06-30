package org.nick.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rates")
@XmlRootElement(name = "rates")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "rates_rate",
            joinColumns = {@JoinColumn(name = "rates_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "rate_id", referencedColumnName = "id")}
    )
    @XmlElement(name = "rate")
    private List<Rate> rates = new ArrayList<>();

    @OneToOne(mappedBy = "rates")
    @XmlTransient
    private Form form;

    @Override
    public String toString() {
        return "Rates{" +
                "id=" + id +
                ", rates=" + rates +
                '}';
    }
}