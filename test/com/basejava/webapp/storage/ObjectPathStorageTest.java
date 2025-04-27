package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectPathStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        return new PathStorage(STORAGE_DIR, new ObjectStreamSerializer());
    }
}
