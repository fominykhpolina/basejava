package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.DataStreamSerializer;

public class DataPathStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        return new PathStorage(STORAGE_DIR, new DataStreamSerializer());
    }
}
