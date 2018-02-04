package ru.itpark.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studygroup")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//
//    @OneToMany(mappedBy = "student")
//    private List<Student> students;
}
