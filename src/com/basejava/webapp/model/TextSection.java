package com.basejava.webapp.model;

public class TextSection extends Section {

    private static final long serialVersionUID = 1L;

    private final String content;

    public TextSection(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        TextSection that = (TextSection) object;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}