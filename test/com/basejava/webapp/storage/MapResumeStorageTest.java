package com.basejava.webapp.storage;

import static org.junit.Assert.*;

public class MapResumeStorageTest extends AbstractStorageTest {
    protected Storage createStorage() {
        return new MapResumeStorage();
    }
}
