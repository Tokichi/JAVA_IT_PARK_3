package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.forms.AddStudentForm;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.Role;
import ru.itpark.models.State;
import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User getStudent(Long userId) {
        return usersRepository.findOne(userId);
    }

    @Override
    public List<User> getAllStudents() {
        return usersRepository.findAllByRole(Role.STUDENT);
    }


    @Override
    public void update(Long userId, NamesForm form) {
        User user = usersRepository.findOne(userId);
        form.update(user);
        usersRepository.save(user);
    }

    @Override
    public void saveStudent(AddStudentForm form) {
        User newStudent = User.builder()
                .name(form.getName())
                .surname(form.getSurname())
                .patronymic(form.getPatronymic())
                .email(form.getEmail())
                .state(State.CONFIRMED)
                .role(Role.STUDENT)
                .hashPassword(encoder.encode(form.getPassword()))
                .build();

        usersRepository.save(newStudent);
    }
}
