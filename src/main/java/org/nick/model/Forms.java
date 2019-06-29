package org.nick.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

@Entity
@Table(name = "forms")
@XmlRootElement(name = "forms")
public class Forms {

    @Id
    @GeneratedValue
    @XmlTransient
    private int id;

    @OneToMany(mappedBy = "forms")
    @XmlElement(name = "form")
    private ArrayList<Form> forms;

    public Forms() {
        this.id = -1;
    }

    @Override
    public String toString() {
        return "Forms{" +
                "forms=" + forms +
                '}';
    }
}