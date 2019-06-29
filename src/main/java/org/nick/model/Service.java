package org.nick.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;
import java.util.List;


@Entity
@Table(name = "service")
@XmlRootElement(name = "service")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @XmlAttribute(name = "id")
    private int id;
    @XmlValue
    private String service;

    @OneToMany(mappedBy = "service")
    @XmlTransient
    private List<Data> data;
}