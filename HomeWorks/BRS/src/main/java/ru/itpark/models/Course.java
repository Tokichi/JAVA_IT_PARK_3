package ru.itpark.models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String teacherName;
    private String disciplineName;
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User tacher;
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public void update(Course course) {
        course.setGroupName(this.groupName);
    }
}
