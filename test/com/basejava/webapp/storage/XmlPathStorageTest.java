package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.XmlStreamSerializer;
import java.nio.file.Path;

public class XmlPathStorageTest extends AbstractStorageTest {

        @Override
        protected Storage createStorage() {
            return new PathStorage(getStorageDir(), new XmlStreamSerializer());
        }

        private Path getStorageDir() {
            if (STORAGE_DIR == null) {
                throw new IllegalStateException("STORAGE_DIR is not initialized yet");
            }
            return STORAGE_DIR;
        }
    }