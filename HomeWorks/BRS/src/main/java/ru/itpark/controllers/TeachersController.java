package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.AddStudentForm;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.UsersService;

import java.util.List;

@Controller
public class TeachersController {
    @Autowired
    private UsersService service;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/teachers")
    public String getAddStudentPage() {
        return "students_page";
    }

    @PostMapping("/teachers")
    public String registrationUser(@ModelAttribute AddStudentForm form,
                                   @ModelAttribute("model") ModelMap model) {
        service.saveStudent(form);
        return "students_page";
    }
}
