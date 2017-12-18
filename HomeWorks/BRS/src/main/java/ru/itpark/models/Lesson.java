package ru.itpark.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Lesson {
    private int id;
    private long startTime;
    private long endTime;
    private Course course;
}
