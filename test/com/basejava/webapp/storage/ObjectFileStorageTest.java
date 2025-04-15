package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectFileStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        return new FileStorage(STORAGE_DIR.toFile(), new ObjectStreamSerializer());
    }
}