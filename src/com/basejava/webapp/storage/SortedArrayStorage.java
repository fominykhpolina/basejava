package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume();
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void deletedElement(int index) {
        int number = size - index - 1;
        if (number > 0) {
            System.arraycopy(storage, index + 1, storage, index, number);
        }
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        int indexInsert = index - 1;
        System.arraycopy(storage, indexInsert, storage, indexInsert + 1, size - indexInsert);
        storage[indexInsert] = resume;
    }
}