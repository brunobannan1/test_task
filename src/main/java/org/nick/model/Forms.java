package org.nick.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "forms")
@XmlRootElement(name = "forms")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Forms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @OneToMany(mappedBy = "forms")
    @XmlElement(name = "form")
    private List<Form> forms;

    @Override
    public String toString() {
        return "Forms{" +
                "id=" + id +
                '}';
    }
}