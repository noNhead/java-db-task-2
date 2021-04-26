package org.example.repository;

import java.sql.Timestamp;
import java.util.Map;

public interface RepositoryCrudFlowerFromSupplier <T, D> {
        Map<String, Object> select(int id);

        int delete(int id);

        int update(T objectT, D objectD, Timestamp timestamp, int id);

        int create(T objectT, D objectD, Timestamp timestamp);
}
