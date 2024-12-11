package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
            Resume[] resumes = new Resume[size];
            System.arraycopy(storage, 0, resumes, 0, size);
        }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == - 1) {
            System.out.println("Резюме " + resume.getUuid() + " не существует");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Резюме " + resume.getUuid() + " существует");
        } else if (size > storage.length) {
            System.out.println("Хранилище заполнено");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме " + uuid + " не существует");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}