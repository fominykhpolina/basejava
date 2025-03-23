package com.basejava.webapp.model;

import java.util.List;

public class ListSection extends Section {

    private final List<String> items;

    public ListSection(List<String> items) {
        this.items = items;
    }
}
