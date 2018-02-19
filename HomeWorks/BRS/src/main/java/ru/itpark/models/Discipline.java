package ru.itpark.models;

import lombok.*;
import javax.persistence.*;
@Entity
@Table(name = "discipline")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public void update(Discipline discipline) {
        discipline.setName(this.name);
    }
}
