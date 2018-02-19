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
public class GroupsServiceImpl implements GroupsService {
    @Autowired
    private GroupsRepository groupsRepository;

    @Override
    public Group getGroup(Long groupId) {
        return groupsRepository.findOne(groupId);
    }

    @Override
    public void update(Long groupId, Group form) {
        Group group = groupsRepository.findOne(groupId);
        form.update(group);
        groupsRepository.save(group);

    }

    @Override
    public List<Group> getAllGroup() {
        return groupsRepository.findAll();
    }

    @Override
    public void saveGroup(Group form) {
        groupsRepository.save(form);
    }

    @Override
    public void deleteGroup(Long groupId) {
        groupsRepository.delete(groupId);
    }
}
