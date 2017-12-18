package ru.itpark.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Student {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String login;
    private String password;
    private String email;
    private Group group;
}
