package com.basejava.webapp.storage;

import static org.junit.Assert.*;

public class MapStorageTest extends AbstractStorageTest {
    protected Storage createStorage() {
        return new MapStorage();
    }
}