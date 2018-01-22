package ru.itpark.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String patronymic;
    private String login;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name = "gruppa_id")
    private Gruppa gruppa;
}
