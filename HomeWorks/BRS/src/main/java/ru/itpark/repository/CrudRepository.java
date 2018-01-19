package ru.itpark.repository;

import ru.itpark.models.Student;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();

    void save(T model);
}
