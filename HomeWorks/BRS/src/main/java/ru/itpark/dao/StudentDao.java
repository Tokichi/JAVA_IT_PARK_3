package ru.itpark.dao;

import ru.itpark.models.Student;

import java.util.List;

public interface StudentDao extends CrudDao<Student> {
    List<Student> findAllByGroup(String group);

}
