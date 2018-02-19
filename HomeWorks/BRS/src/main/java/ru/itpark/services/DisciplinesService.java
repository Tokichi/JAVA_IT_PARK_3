package ru.itpark.services;

import ru.itpark.models.Discipline;

import java.util.List;

public interface DisciplinesService {
    Discipline getDiscipline(Long disciplineId);
    void update(Long disciplineId, Discipline form);
    List<Discipline> getAllDiscipline();
    void saveDiscipline(Discipline form);
    void deleteDiscipline(Long disciplineId);
}
