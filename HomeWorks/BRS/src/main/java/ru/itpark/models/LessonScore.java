package ru.itpark.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class LessonScore {
    private int id;
    private Lesson lesson;

}
