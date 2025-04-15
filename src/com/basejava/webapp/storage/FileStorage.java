package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.serializer.StreamSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage <File> {

    private final File directory;
<<<<<<< HEAD:src/com/basejava/webapp/storage/AbstractFileStorage.java

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;
=======
    private final StreamSerializer streamSerializer;
>>>>>>> HW9:src/com/basejava/webapp/storage/FileStorage.java

    protected FileStorage(File directory, StreamSerializer streamSerializer) {
        Objects.requireNonNull(directory, "Directory not null");
        this.streamSerializer = streamSerializer;
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
<<<<<<< HEAD:src/com/basejava/webapp/storage/AbstractFileStorage.java
            doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
=======
            streamSerializer.doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
>>>>>>> HW9:src/com/basejava/webapp/storage/FileStorage.java
        } catch (IOException e) {
            throw new StorageException("Error", resume.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected Resume doGet(File file) {
        try {
<<<<<<< HEAD:src/com/basejava/webapp/storage/AbstractFileStorage.java
            return doRead(new BufferedInputStream(new FileInputStream(file)));
=======
            return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(file)));
>>>>>>> HW9:src/com/basejava/webapp/storage/FileStorage.java
        } catch (IOException e) {
            throw new StorageException("Error", file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if(!file.delete()) {
            throw new StorageException("Error", file.getName());
        }
    }

    @Override
    protected void doSave(Resume resume, File file) {
        try {
            file.createNewFile();
<<<<<<< HEAD:src/com/basejava/webapp/storage/AbstractFileStorage.java
            doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
=======
>>>>>>> HW9:src/com/basejava/webapp/storage/FileStorage.java
        } catch (IOException e) {
            throw new StorageException("IO error" + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(resume, file);
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = getFiles();
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    public void clear() {
        for (File file : getFiles()) {
            doDelete(file);
        }
    }

    @Override
    public int size() {
        return getFiles().length;
    }

    private File[] getFiles() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error");
        }
        return files;
    }
}