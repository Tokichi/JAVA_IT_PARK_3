package ru.itpark.forms;

import lombok.Data;
import ru.itpark.models.User;

@Data
public class NamesForm {
    private String name;
    private String surname;
    private String patronymic;
    private String email;


    public void update(User user) {
        user.setName(this.name);
        user.setSurname(this.surname);
        user.setPatronymic(this.patronymic);
        user.setEmail(this.email);
    }

}