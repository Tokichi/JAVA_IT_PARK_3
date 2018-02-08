package ru.itpark.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brs_group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//   @OneToMany(mappedBy = "student")
//   private List<Student> students;
}
