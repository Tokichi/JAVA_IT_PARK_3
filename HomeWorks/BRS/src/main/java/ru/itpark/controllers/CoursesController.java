package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.models.Course;
import ru.itpark.models.Discipline;
import ru.itpark.models.Group;
import ru.itpark.models.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.*;

import java.util.List;

@Controller
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private GroupsService groupsService;
    @Autowired
    private DisciplinesService disciplinesService;
    @Autowired
    private UsersService teacherService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/courses")
    public String getCourses(@ModelAttribute("model") ModelMap model, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        List<Course> courses = coursesService.getAllCourse();
        model.addAttribute("courses", courses);
        return "courses_page";
    }

//    @GetMapping("/courses/{course-id}")
//    public String getCoursePage(@ModelAttribute("model") ModelMap model,
//                               @PathVariable("course-id") Long courseId, Authentication authentication) {
//
//        User currentUser = authenticationService.getUserByAuthentication(authentication);
//        model.addAttribute("currentUser", currentUser);
//
//        Course course = service.getCourse(courseId);
//        model.addAttribute("course", course);
//        return "course_page";
//    }

//    @PostMapping("/courses/{course-id}")
//    public String updateCourse(@PathVariable("course-id") Long courseId,
//                               Course form) {
//        service.update(courseId, form);
//        return "redirect:/courses";
//    }

    @GetMapping("/addCourse")
    public String getAddCoursePage(@ModelAttribute("model") ModelMap model, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        List<Group> groups = groupsService.getAllGroup();
        model.addAttribute("groups", groups);
        List<Discipline> disciplines = disciplinesService.getAllDiscipline();
        model.addAttribute("disciplines", disciplines);
        List<User> users = teacherService.getAllTeachers();
        model.addAttribute("users", users);
        return "add_course_page";
    }

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute Group group,
                            @ModelAttribute Discipline discipline,
                            @ModelAttribute User user) {
        coursesService.saveCourse(group, discipline, user);
        return "redirect:/courses";
    }

    @GetMapping("/courses/delete/{course-id}")
    public String getDeleteCourse(@PathVariable("course-id") Long courseId) {

        coursesService.deleteCourse(courseId);
        return "redirect:/courses";
    }
}