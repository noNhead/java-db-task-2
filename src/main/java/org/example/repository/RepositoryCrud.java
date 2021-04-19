package org.example.repository;

public interface RepositoryCrud<T> {

    public T select(int id);

    public void delete(T object);

    public void update(T object);

    public void create(T object);
}
