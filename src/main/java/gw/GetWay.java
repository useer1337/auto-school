package gw;

import exceptions.EntityNotFound;

import java.util.List;

public interface GetWay<T> {
    List<T> all();

    T find(int id) throws EntityNotFound;

    void insert(T object);

    void update(T object) throws EntityNotFound;

    void delete(T object);
}
