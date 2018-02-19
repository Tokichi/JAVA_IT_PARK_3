package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itpark.models.User;
import ru.itpark.services.AuthenticationService;

@Controller
public class MainPageController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/")
    public String getMainPage(Authentication authentication,
                              @ModelAttribute("model") ModelMap model) {
        if (authentication != null) {
            User currentUser = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("currentUser", currentUser);
        }
        return "main_page";
    }

}