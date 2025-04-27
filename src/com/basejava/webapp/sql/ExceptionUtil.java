package com.basejava.webapp.sql;

import org.postgresql.util.PSQLException;
import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.StorageException;
import java.sql.SQLException;

public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static StorageException convertException(SQLException e) {
        if (e instanceof PSQLException) {

            if (e.getSQLState().equals(" ")) {
                return new ExistStorageException(null);
            }
        }
        return new StorageException(e);
    }
}