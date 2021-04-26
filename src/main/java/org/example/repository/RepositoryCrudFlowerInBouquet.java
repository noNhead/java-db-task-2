package org.example.repository;

import java.util.Map;

public interface RepositoryCrudFlowerInBouquet<T, D> {
    Map<String, Object> select(int id);

    int delete(int id);

    int update(T objectT, D objectD, int id);

    int create(T objectT, D objectD);
}
