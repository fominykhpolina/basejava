package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume resume) {
        int num = getNum(resume.getUuid());
        if (num == - 1) {
            System.out.println("Резюме " + resume.getUuid() + " не существует");
        } else {
            storage[num] = resume;
        }
    }

    public void save(Resume resume) {
        if (getNum(resume.getUuid()) != -1) {
            System.out.println("Резюме " + resume.getUuid() + " существует");
        } else if (size > storage.length) {
            System.out.println("Хранилище заполнено");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int num = getNum(uuid);
        if (num == -1) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        }
        return storage[num];
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size++;
                return;
            }
        }
    }

    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    public int size() {
        return size;
    }
    private int getNum(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return 0;
    }
}
