package ru.itpark.repository;

import ru.itpark.models.Teacher;

import javax.persistence.EntityManager;
import java.util.List;

public class TeachersRepositoryEntityManagerImpl implements TeachersRepository {

    private EntityManager entityManager;

    public TeachersRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Teacher> findAll() {
        return entityManager
                .createQuery("from Teacher teacher order by teacher.id", Teacher.class)
                .getResultList();
    }

    @Override
    public void save(Teacher model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }
}