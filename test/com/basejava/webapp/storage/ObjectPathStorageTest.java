package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.ObjectStreamSerializer;

import java.nio.file.Path;

public class ObjectPathStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        return new PathStorage(getStorageDir(), new ObjectStreamSerializer());
    }

    private Path getStorageDir() {
        if (STORAGE_DIR == null) {
            throw new IllegalStateException("STORAGE_DIR is not initialized yet");
        }
        return STORAGE_DIR;
    }
}
