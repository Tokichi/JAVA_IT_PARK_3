package ru.itpark.models;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "brs_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String goupName;
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


    public void update(User user) {
        user.setName(this.name);
        user.setSurname(this.surname);
        user.setPatronymic(this.patronymic);
        user.setEmail(this.email);
    }
}