package ru.itpark.services;

import ru.itpark.forms.LessonForm;
import ru.itpark.models.Course;
import ru.itpark.models.Lesson;

import java.util.List;

public interface LessonsService {

    Lesson getLesson(Long lessonId);
    List<Lesson> getAllLesson();
    void saveLesson(LessonForm form, Course course);
    void deleteLesson(Long lessonId);
}