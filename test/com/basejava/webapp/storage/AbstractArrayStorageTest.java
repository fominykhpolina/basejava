package com.basejava.webapp.storage;

import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @org.junit.Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @org.junit.Test
    public void update() {
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);
        assertTrue(newResume == storage.get(UUID_1));
    }

    @org.junit.Test
    public void get() {
        assertGet(new Resume(UUID_1));
        assertGet(new Resume(UUID_2));
        assertGet(new Resume(UUID_3));
    }

    @org.junit.Test
    public void save() {
        storage.save(new Resume(UUID_4));
        Assert.assertEquals(4, storage.size());
    }

    @org.junit.Test
    public void delete() {
        storage.delete(UUID_3);
        Assert.assertEquals(2, storage.size());
    }

    @org.junit.Test
    public void getAll() {
        Resume[] array = storage.getAll();
        Assert.assertEquals(3, array.length);
        assertEquals(new Resume(UUID_1), array[0]);
        assertEquals(new Resume(UUID_2), array[1]);
        assertEquals(new Resume(UUID_3), array[2]);
    }

    @org.junit.Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}