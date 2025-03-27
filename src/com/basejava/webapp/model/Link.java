package com.basejava.webapp.model;

public class Link {

    private final String name;
    private final String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
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