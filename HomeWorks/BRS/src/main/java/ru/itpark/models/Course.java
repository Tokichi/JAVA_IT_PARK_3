package ru.itpark.models;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Course {
    private int id;
    private Group group;
    private Teacher teacher;
    private Discipline discipline;

}
