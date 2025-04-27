package com.basejava.webapp.storage;

import com.basejava.webapp.Config;

public class SqlStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        return new SqlStorage(
                Config.get().getDbUrl(),
                Config.get().getDbUser(),
                Config.get().getDbPassword()
        );
    }
}