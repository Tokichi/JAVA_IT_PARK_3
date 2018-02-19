package ru.itpark.forms;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LessonForm {
    private String year;
    private String month;
    private String day;
    private String time;
}