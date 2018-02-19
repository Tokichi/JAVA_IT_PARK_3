package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.forms.LessonForm;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.*;
import ru.itpark.repositories.LessonsRepository;
import ru.itpark.repositories.UsersRepository;

import java.util.List;

@Service
public class LessonsServiceImpl implements LessonsService {
    @Autowired
    private LessonsRepository lessonsRepository;

    @Override
    public Lesson getLesson(Long lessonId) {
        return lessonsRepository.findOne(lessonId);
    }


    @Override
    public List<Lesson> getAllLesson() {
        return lessonsRepository.findAll();
    }

    @Override
    public void saveLesson(LessonForm form, Course course) {
        Lesson lesson = Lesson.builder()
                .lessonDay(form.getYear()+"-"+form.getMonth()+"-"+form.getDay())
                .lessonTime(form.getTime())
                .nameCourse(course.getCourseName())
                .course(course)
                .build();
        lessonsRepository.save(lesson);
    }

    @Override
    public void deleteLesson(Long lessonId) {
        lessonsRepository.delete(lessonId);
    }
}