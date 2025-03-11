package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Object getKeySearch(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume resume, Object keySearch) {
        list.set((Integer) keySearch, resume);
    }

    @Override
    protected boolean isExist(Object keySearch) {
        return false;
    }

    @Override
    protected Resume doGet(Object keySearch) {
        return list.get((Integer) keySearch);
    }

    @Override
    protected void doDelete(Object keySearch) {
        list.remove(((Integer) keySearch));
    }

    @Override
    protected void doSave(Resume resume, Object keySearch) {
        list.add(resume);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }
}