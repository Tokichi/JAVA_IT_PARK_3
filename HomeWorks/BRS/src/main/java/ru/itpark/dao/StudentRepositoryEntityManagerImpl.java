package ru.itpark.dao;

import ru.itpark.models.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepositoryEntityManagerImpl implements StudentDao {

    private EntityManager entityManager;

    public StudentRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public void update(Student model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Student> findAll() {
        return entityManager
                .createQuery("from Student student order by student.id", Student.class)
                .getResultList();
    }

    @Override
    public void save(Student model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Student> findAllByGroup(String group) {
        return null;
    }
}