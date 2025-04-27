package com.basejava.webapp.storage;

import com.basejava.webapp.model.*;

import java.time.Month;
import java.util.Arrays;

public class ResumeTestData {

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

       /* resume.addContact(ContactType.MAIL, "mail@yandex.ru");
        resume.addContact(ContactType.PHONE, "7911");
        resume.addContact(ContactType.SKYPE, "skype" + fullName.toLowerCase());

        resume.addSection(SectionType.OBJECTIVE, new TextSection("Object1"));
        resume.addSection(SectionType.PERSONAL, new TextSection("Personal1"));

        resume.addSection(SectionType.ACHIEVEMENT, new ListSection("Achievement1", "Achievement2", "Achievement3"));

        resume.addSection(SectionType.QUALIFICATIONS, new ListSection("Java"));

        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization(
                        new Link("Organization1", "http://Organization1.ru"),
                        Arrays.asList(
                                new Organization.Position(2010, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2015, Month.MARCH, 2017, Month.JANUARY, "position2", "content2"))),
                new Organization(
                        new Link("Organization2", "http://Organization2.ru"),
                        Arrays.asList(
                                new Organization.Position(2015, Month.JANUARY, "position3", "content3")))));

        resume.addSection(SectionType.EDUCATION, new OrganizationSection(
                new Organization(
                        new Link("Institute", null),
                        Arrays.asList(
                                new Organization.Position(1990, Month.JANUARY, 1994, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2012, Month.MARCH, 2016, Month.JANUARY, "student", "IT facultet"))),
                new Organization(
                        new Link("Organization2", "http://Organization2.ru"),
                        Arrays.asList())));
        */
        return resume;
    }
}