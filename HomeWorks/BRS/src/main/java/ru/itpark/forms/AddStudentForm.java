package ru.itpark.forms;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddStudentForm {
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String password;
}
