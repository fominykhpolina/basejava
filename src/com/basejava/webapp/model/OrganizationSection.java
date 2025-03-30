package com.basejava.webapp.model;

import java.util.Arrays;
import java.util.List;

public class OrganizationSection extends Section {

    private final List<Organization> organizations;

    public OrganizationSection(Organization... organizations) {
        this(Arrays.asList(organizations));
    }

    public OrganizationSection(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        OrganizationSection that = (OrganizationSection) object;

        return organizations.equals(that.organizations);
    }

    @Override
    public String toString() {
        return organizations.toString();
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }
}