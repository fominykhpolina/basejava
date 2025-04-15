package com.basejava.webapp.storage;

import static org.junit.Assert.*;

public class ArrayStorageTest extends AbstractArrayStorageTest{

    protected Storage createStorage() {
        return new ArrayStorage();
    }
}