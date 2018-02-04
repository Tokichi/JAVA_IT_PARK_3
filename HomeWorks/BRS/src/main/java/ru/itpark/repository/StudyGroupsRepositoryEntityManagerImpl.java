package ru.itpark.repository;

import ru.itpark.models.StudyGroup;

import javax.persistence.EntityManager;
import java.util.List;

public class StudyGroupsRepositoryEntityManagerImpl implements StudyGroupsRepository {

    private EntityManager entityManager;

    public StudyGroupsRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<StudyGroup> findAll() {
        return entityManager
                .createQuery("from StudyGroup studyGroup order by studygroup.id", StudyGroup.class)
                .getResultList();
    }

    @Override
    public void save(StudyGroup model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }
}