package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        return new PathStorage(STORAGE_DIR, new XmlStreamSerializer());
    }
}
