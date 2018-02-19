package ru.itpark.services;

import ru.itpark.forms.GroupForm;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.Group;
import ru.itpark.models.User;

import java.util.List;

public interface UsersService {

    User getUser(Long userId);

    void update(Long userId, User form);
    List<User> getAllStudents();
    List<User> getAllTeachers();
    List<User> getStudentsByGroup(Long groupId);
    void saveStudent(NamesForm form, Group group);
    void saveTeacher(NamesForm form);
    void deleteUser(Long userId);
}
