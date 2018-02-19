package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.models.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.UsersService;

@Controller
public class UsersController {

    @Autowired
    private UsersService service;

    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping("/login")
    public String login(
            @ModelAttribute("model") ModelMap model,
            @RequestParam(value = "error", required = false) Boolean error) {
        if (error != null) {
            model.addAttribute("error", true);
        } else {
            model.addAttribute("error", false);
        }
        return "login";
    }

}