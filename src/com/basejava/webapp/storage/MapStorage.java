package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume resume, Object uuid) {
        storage.put((String) uuid, resume);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return storage.containsKey((String) uuid);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return storage.get((String) uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        storage.remove((String) uuid);
    }

    @Override
    protected void doSave(Resume resume, Object uuid) {
        storage.put((String) uuid, resume);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return Collections.emptyList();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
