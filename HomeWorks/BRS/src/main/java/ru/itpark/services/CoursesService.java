package ru.itpark.services;

import ru.itpark.models.*;

import java.util.List;

public interface CoursesService {

    Course getCourse(Long courseId);
    void update(Long courseId, Course form);
    List<Course> getAllCourse();
    void saveCourse(Group group, Discipline discipline, User user);
    void deleteCourse(Long courseId);
}