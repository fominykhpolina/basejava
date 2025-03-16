package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage[(Integer) index] = resume;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected void doDelete(Object index) {
        deletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void doSave(Resume resume, Object index) {
        if (size > storage.length) {
            throw new StorageException("Хранилище заполнено", resume.getUuid());
        } else {
            insertElement(resume, (Integer) index);
            size++;
        }
    }

    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    protected abstract void deletedElement ( int index);

    protected abstract void insertElement (Resume resume,int index);

    protected abstract Integer getSearchKey (String uuid);
}