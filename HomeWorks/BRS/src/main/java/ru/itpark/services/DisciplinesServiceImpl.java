package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.Discipline;
import ru.itpark.models.Role;
import ru.itpark.models.State;
import ru.itpark.models.User;
import ru.itpark.repositories.DisciplinesRepository;
import ru.itpark.repositories.UsersRepository;

import java.util.List;

@Service
public class  DisciplinesServiceImpl implements DisciplinesService {
    @Autowired
    private DisciplinesRepository disciplinesRepository;

    @Override
    public Discipline getDiscipline(Long disciplineId) {
        return disciplinesRepository.findOne(disciplineId);
    }

    @Override
    public void update(Long disciplineId, Discipline form) {
        Discipline discipline = disciplinesRepository.findOne(disciplineId);
        form.update(discipline);
        disciplinesRepository.save(discipline);

    }

    @Override
    public List<Discipline> getAllDiscipline() {
        return disciplinesRepository.findAll();
    }

    @Override
    public void saveDiscipline(Discipline form) {
        disciplinesRepository.save(form);
    }

    @Override
    public void deleteDiscipline(Long disciplineId) {
        disciplinesRepository.delete(disciplineId);
    }
}