package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.Role;
import ru.itpark.models.State;
import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;

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
    public void saveStudent(User form) {
        form.setHashPassword(encoder.encode(form.getHashPassword()));
        form.setRole(Role.STUDENT);
        form.setState(State.CONFIRMED);
        usersRepository.save(form);
    }

}
