package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ru.itpark.models.Course;
import ru.itpark.models.Discipline;
import ru.itpark.models.Group;
import ru.itpark.models.User;
import ru.itpark.repositories.CoursesRepository;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public Course getCourse(Long courseId) {
        return coursesRepository.findOne(courseId);
    }

    @Override
    public void update(Long courseId, Course form) {
        Course course = coursesRepository.findOne(courseId);
        form.update(course);
        coursesRepository.save(course);

    }

    @Override
    public List<Course> getAllCourse() {
        return coursesRepository.findAll();
    }

    @Override
    public void saveCourse(Group group, Discipline discipline, User user) {
        Course course = Course.builder()
                .group(group)
                .groupName(group.getName())
                .discipline(discipline)
                .disciplineName(discipline.getName())
                .tacher(user)
                .teacherName(user.getSurname() + " " + user.getName() + " " + user.getPatronymic())
                .courseName("Группа - " + group.getName() + ", Дисциплина - " + discipline.getName() + ", Преподаватель - " + user.getSurname() + " " + user.getName() + " " + user.getPatronymic())
                .build();
        user.setGroup(null);
        coursesRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        coursesRepository.delete(courseId);
    }
}
