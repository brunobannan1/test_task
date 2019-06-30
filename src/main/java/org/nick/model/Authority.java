package org.nick.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authority")
@XmlRootElement(name = "authority")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    @Id
    @XmlAttribute(name = "id")
    private int id;

    @XmlValue
    private String authority;

    @OneToMany(mappedBy = "authority", cascade = CascadeType.ALL)
    @XmlTransient
    private List<Data> data = new ArrayList<>();

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
