package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.models.Discipline;
import ru.itpark.models.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.DisciplinesService;

import java.util.List;

@Controller
public class DisciplinesController {

    @Autowired
    private DisciplinesService disciplinesService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/disciplines")
    public String getDisciplines(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        List<Discipline> disciplines = disciplinesService.getAllDiscipline();
        model.addAttribute("discipline", disciplines);
        return "disciplines_page";
    }

    @GetMapping("/disciplines/{discipline-id}")
    public String getDisciplinePage(@ModelAttribute("model") ModelMap model,
                               @PathVariable("discipline-id") Long disciplineId, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        Discipline discipline = disciplinesService.getDiscipline(disciplineId);
        model.addAttribute("discipline", discipline);
        return "discipline_page";
    }

    @PostMapping("/disciplines/{discipline-id}")
    public String updateDiscipline(@PathVariable("discipline-id") Long disciplineId,
                              Discipline form) {
        disciplinesService.update(disciplineId, form);
        return "redirect:/disciplines";
    }

    @GetMapping("/addDiscipline")
    public String getAddDisciplinePage(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);
        return "add_discipline_page";
    }

    @PostMapping("/addDiscipline")
    public String addDiscipline(@ModelAttribute Discipline form) {
        disciplinesService.saveDiscipline(form);
        return "redirect:/disciplines";
    }

    @GetMapping("/disciplines/delete/{discipline-id}")
    public String getDeleteDisciplines(@PathVariable("discipline-id") Long disciplineId) {
        disciplinesService.deleteDiscipline(disciplineId);
        return "redirect:/disciplines";
    }
}
