package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage <SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, SK search);

    protected abstract boolean isExist(SK search);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK search);

    protected abstract void doSave(Resume resume, SK search);

    protected abstract List<Resume> doCopyAll();

    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK searchKey = getExist(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExist(uuid);
        return doGet(searchKey);
    }

    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = getNotExist(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExist(uuid);
        doDelete(searchKey);
    }

    private SK getExist(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExist(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }
}