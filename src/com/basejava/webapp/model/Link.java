package com.basejava.webapp.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Link implements Serializable {

    private static long serialVersionUID = 1L;
    private String name;
    private String url;

    public Link(String name, String url) {
        this.name = name;
        if (url == null) {
            this.url = "";
        } else {
            this.url = url;
        }
    }

    public Link() {
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Link(" + name + ',' + url + ')';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Link link = (Link) object;

        if (!name.equals(link.name)) return false;
        if (url != null) {
            return url.equals(link.url);
        } else {
            return link.url == null;
        }
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        if (url != null) {
            result = 31 * result + url.hashCode();
        } else {
            result = 31 * result;
        }
        return result;
    }
}