package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object keySearch = getExist(resume.getUuid());
        doUpdate(resume, keySearch);
    }

    public Resume get(String uuid) {
        Object keySearch = getExist(uuid);
        return doGet(keySearch);
    }

    public void save(Resume resume) {
        Object keySearch = getNotExist(resume.getUuid());
        doSave(resume, keySearch);
    }

    public void delete(String uuid) {
        Object keySearch = getExist(uuid);
        doDelete(keySearch);
    }

    protected abstract Object getKeySearch(String uuid);

    protected abstract void doUpdate(Resume resume, Object search);

    protected abstract boolean isExist(Object search);

    protected abstract Resume doGet(Object keySearch);

    protected abstract void doDelete(Object search);

    protected abstract void doSave(Resume resume, Object search);

    private Object getExist(String uuid) {
        Object keySearch = getKeySearch(uuid);
        if (!isExist(keySearch)) {
            throw new NotExistStorageException(uuid);
        }
        return keySearch;
    }

    private Object getNotExist(String uuid) {
        Object keySearch = getKeySearch(uuid);
        if (isExist(keySearch)) {
            throw new ExistStorageException(uuid);
        }
        return keySearch;
    }
}