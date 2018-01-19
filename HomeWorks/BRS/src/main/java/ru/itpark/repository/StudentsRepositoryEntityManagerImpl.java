package ru.itpark.repository;

import ru.itpark.models.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentsRepositoryEntityManagerImpl implements StudentsRepository {

    private EntityManager entityManager;

    public StudentsRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
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
}