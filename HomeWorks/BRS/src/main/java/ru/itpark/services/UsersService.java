package ru.itpark.services;

import ru.itpark.forms.NamesForm;
import ru.itpark.models.User;

import java.util.List;

public interface UsersService {

    User getStudent(Long userId);

    void update(Long userId, NamesForm form);
    List<User> getAllStudents();
    void saveStudent(User form);
}
