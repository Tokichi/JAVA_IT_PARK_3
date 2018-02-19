package ru.itpark.forms;

import lombok.Data;
import lombok.ToString;
import ru.itpark.models.User;

@Data
@ToString
public class NamesForm {
    private String formName;
    private String surname;
    private String patronymic;
    private String email;
    private String password;

    public void update(User user) {
        user.setName(this.formName);
        user.setSurname(this.surname);
        user.setPatronymic(this.patronymic);
        user.setEmail(this.email);
    }

}