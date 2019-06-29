package org.nick.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "xml_user")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @XmlAttribute(name = "id")
    private String id;
    @Column(name = "username")
    @XmlValue
    private String user;

    @OneToMany(mappedBy = "user")
    @XmlTransient
    private List<Data> data;
}
