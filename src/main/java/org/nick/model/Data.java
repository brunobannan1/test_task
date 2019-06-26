package org.nick.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class Data {
    private String user;
    private int serviceId;
    private int procedure;
    private int authorityId;

    public Data () {
    }
}
