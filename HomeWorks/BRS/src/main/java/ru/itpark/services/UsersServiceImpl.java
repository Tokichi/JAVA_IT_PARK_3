package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.forms.GroupForm;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.Group;
import ru.itpark.models.Role;
import ru.itpark.models.State;
import ru.itpark.models.User;
import ru.itpark.repositories.GroupsRepository;
import ru.itpark.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User getUser(Long userId) {
        return usersRepository.findOne(userId);
    }

    @Override
    public List<User> getAllStudents() {

        return usersRepository.findAllByRole(Role.STUDENT);
    }

    @Override
    public List<User> getAllTeachers() {
        return usersRepository.findAllByRole(Role.TEACHER);
    }

    @Override
    public void update(Long userId, User form) {
        User user = usersRepository.findOne(userId);
        form.update(user);
        usersRepository.save(user);
    }

    @Override
    public List<User> getStudentsByGroup(Long groupId) {

        return usersRepository.findAllByGroup_Id(groupId);
    }


    @Override
    public void saveStudent(NamesForm form, Group group) {

        User newStudent = User.builder()
                .name(form.getFormName())
                .surname(form.getSurname())
                .patronymic(form.getPatronymic())
                .email(form.getEmail())
                .state(State.CONFIRMED)
                .role(Role.STUDENT)
                .hashPassword(encoder.encode(form.getPassword()))
                .group(group)
                .goupName(group.getName())
                .build();

        usersRepository.save(newStudent);
    }

    @Override
    public void saveTeacher(NamesForm form) {
        User newTeacher = User.builder()
                .name(form.getFormName())
                .surname(form.getSurname())
                .patronymic(form.getPatronymic())
                .email(form.getEmail())
                .state(State.CONFIRMED)
                .role(Role.TEACHER)
                .hashPassword(encoder.encode(form.getPassword()))
                .build();

        usersRepository.save(newTeacher);
    }

    @Override
    public void deleteUser(Long userId) {
        usersRepository.delete(userId);
    }
}
