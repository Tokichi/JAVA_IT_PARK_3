package ru.itpark.models;

import lombok.*;
import javax.persistence.*;
@Entity
@Table(name = "lesson")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonDay;
    private String lessonTime;
    private String nameCourse;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
