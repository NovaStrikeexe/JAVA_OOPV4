package gateways;

import exceptions.EntityNotFound;

import java.util.List;

public interface Gateway<T extends EntityClass> {
    List<T> all();
    T find(int id) throws EntityNotFound;

    //T find(Long id) throws EntityNotFound;

    void insert(T object);
    void update(T object) throws EntityNotFound;
    void delete(int id);

}
