package ru.itpark.forms;

import lombok.Data;
import lombok.ToString;
import ru.itpark.models.User;

@Data
@ToString
public class GroupForm {
    private Long id;
    private String name;
    public void update(User user) {
        user.setName(this.name);
    }
}

