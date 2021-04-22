package org.example.repository;

public interface RepositoryCrud<T> {

    T select(int id);

    int delete(int id);

    int update(T object);

    int create(T object);
}
