package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.UsersService;

import java.util.List;

@Controller
public class TeachersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/teachers")
    public String getTeachers(@ModelAttribute("model") ModelMap model, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        List<User> users = usersService.getAllTeachers();
        model.addAttribute("users", users);
        return "teachers_page";
    }

    @GetMapping("/teachers/{user-id}")
    public String getTeacherPage(@ModelAttribute("model") ModelMap model,
                              @PathVariable("user-id") Long teachersId, Authentication authentication) {
        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        User user = usersService.getUser(teachersId);
        model.addAttribute("user", user);
        return "teacher_page";
    }

    @PostMapping("/teachers/{user-id}")
    public String updateTeacher(@PathVariable("user-id") Long userId,
                                             User form) {
        usersService.update(userId, form);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/delete/{user-id}")
    public String getDeleteTeacher(@PathVariable("user-id") Long teacherId) {
        usersService.deleteUser(teacherId);
        return "redirect:/teachers";
    }

    @GetMapping("/addTeacher")
    public String getAddTeacherPage(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        return "add_teacher_page";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@ModelAttribute NamesForm form) {
        usersService.saveTeacher(form);
        return "redirect:/teachers";
    }
}
