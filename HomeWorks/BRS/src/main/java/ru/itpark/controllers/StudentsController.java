package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.GroupForm;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.Group;
import ru.itpark.models.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.GroupsService;
import ru.itpark.services.UsersService;

import java.util.List;

@Controller
public class StudentsController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private GroupsService groupsService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/students")
    public String getStudents(@ModelAttribute("model") ModelMap model, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        List<User> users = usersService.getAllStudents();
        model.addAttribute("users", users);
        return "students_page";
    }

    @GetMapping("/students/{user-id}")
    public String getStudentPage(@ModelAttribute("model") ModelMap model,
                              @PathVariable("user-id") Long studentId, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        User user = usersService.getUser(studentId);
        model.addAttribute("user", user);
        return "student_page";
    }

    @PostMapping("/students/{user-id}")
    public String updateStudent(@PathVariable("user-id") Long userId,
                             User form) {
        usersService.update(userId, form);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{user-id}")
    public String getDeleteStudent(@PathVariable("user-id") Long studentId) {
        usersService.deleteUser(studentId);
        return "redirect:/students";
    }

    @GetMapping("/addStudent")
    public String getAddStudentPage(@ModelAttribute("model") ModelMap model, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        List<Group> groups = groupsService.getAllGroup();
        model.addAttribute("groups", groups);
        return "add_student_page";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute NamesForm form, @ModelAttribute Group group) {
            usersService.saveStudent(form, group);
            return "redirect:/students";
    }
}

