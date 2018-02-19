package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.LessonForm;
import ru.itpark.models.Course;
import ru.itpark.models.Group;
import ru.itpark.models.Lesson;
import ru.itpark.models.User;
import ru.itpark.services.*;

import java.util.List;

@Controller
public class LessonsController {

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private LessonsService lessonsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/lessons")
    public String getLessons(@ModelAttribute("model") ModelMap model, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        List<Lesson> lessons = lessonsService.getAllLesson();
        model.addAttribute("lessons", lessons);
        return "lessons_page";
    }

    //    @GetMapping("/lessons/{lesson-id}")
//    public String getLessonPage(@ModelAttribute("model") ModelMap model,
//                               @PathVariable("lesson-id") Long lessonId, Authentication authentication) {
//
//        User currentUser = authenticationService.getUserByAuthentication(authentication);
//        model.addAttribute("currentUser", currentUser);
//
//        Lesson lesson = service.getLesson(lessonId);
//        model.addAttribute("lesson", lesson);
//        return "lesson_page";
//    }
//
//    @PostMapping("/lessons/{lesson-id}")
//    public String updateLesson(@PathVariable("lesson-id") Long lessonId,
//                               Lesson form) {
//        service.update(lessonId, form);
//        return "redirect:/lessons";
//    }
//
    @GetMapping("/addLesson")
    public String getAddLessonPage(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);
        List<Course> courses = coursesService.getAllCourse();
        model.addAttribute("courses", courses);
        return "add_lesson_page";
    }

    @PostMapping("/addLesson")
    public String addLesson(@ModelAttribute LessonForm form, @ModelAttribute Course course) {
        lessonsService.saveLesson(form, course);
        return "redirect:/lessons";
    }

    @GetMapping("/lessons/delete/{lesson-id}")
    public String getDeleteCourse(@PathVariable("lesson-id") Long lessonId) {
        lessonsService.deleteLesson(lessonId);
        return "redirect:/lessons";
    }

    @GetMapping("/lessonScore/{lesson-id}")
    public String getLessonScorePage(@PathVariable("lesson-id") Long lessonId,
                                     @ModelAttribute("model") ModelMap model, Authentication authentication) {
        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);
        Lesson lesson = lessonsService.getLesson(lessonId);
        Course course = coursesService.getCourse(lesson.getCourse().getId());
        List<User> users = usersService.getStudentsByGroup(course.getGroup().getId());
        model.addAttribute("course", course);
        model.addAttribute("users", users);
        return "lesson_score_page";
    }
}