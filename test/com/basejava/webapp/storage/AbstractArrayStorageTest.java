package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    @Test(expected = StorageException.class)
    public void SaveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT + 1; i++) {
                storage.save(new Resume("Name"));
            }
        } catch (StorageException e) {
            Assert.fail("StorageException thrown too early");
        }
        storage.save(new Resume("OverFlow"));
    }
}
