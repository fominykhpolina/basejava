package com.basejava.webapp.storage;

import static org.junit.Assert.*;

public class ListStorageTest extends AbstractStorageTest {
    protected Storage createStorage() {
        return new ListStorage();
    }
}