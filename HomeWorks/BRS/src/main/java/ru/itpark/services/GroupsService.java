package ru.itpark.services;

import ru.itpark.forms.GroupForm;
import ru.itpark.models.Group;

import java.util.List;

public interface GroupsService {

    Group getGroup(Long groupId);
    void update(Long groupId, Group form);
    List<Group> getAllGroup();
    void saveGroup(Group form);
    void deleteGroup(Long groupId);
}
