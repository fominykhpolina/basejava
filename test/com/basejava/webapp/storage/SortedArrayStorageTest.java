package com.basejava.webapp.storage;

import static org.junit.Assert.*;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    protected Storage createStorage() {
        return new SortedArrayStorage();
    }
}