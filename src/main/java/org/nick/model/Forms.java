package org.nick.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity
@Table(name = "forms")
@XmlRootElement(name = "forms")
public class Forms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @OneToMany(mappedBy = "forms")
    @XmlElement(name = "form")
    private List<Form> forms;

    public Forms() {
    }

    @Override
    public String toString() {
        return "Forms{" +
                "forms=" + forms +
                '}';
    }
}