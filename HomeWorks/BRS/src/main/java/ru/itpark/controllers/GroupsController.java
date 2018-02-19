package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.GroupForm;
import ru.itpark.models.Group;
import ru.itpark.models.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.GroupsService;

import java.util.List;

@Controller
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/groups")
    public String getGroups(@ModelAttribute("model") ModelMap model, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        List<Group> groups = groupsService.getAllGroup();
        model.addAttribute("groups", groups);
        return "groups_page";
    }

    @GetMapping("/groups/{group-id}")
    public String getGroupPage(@ModelAttribute("model") ModelMap model,
                              @PathVariable("group-id") Long groupId, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        Group group = groupsService.getGroup(groupId);
        model.addAttribute("group", group);
        return "group_page";
    }

    @PostMapping("/groups/{group-id}")
    public String updateGroup(@PathVariable("group-id") Long groupId,
                                             Group form) {
        groupsService.update(groupId, form);
        return "redirect:/groups";
    }

    @GetMapping("/addGroup")
    public String getAddGroupPage(@ModelAttribute("model") ModelMap model, Authentication authentication) {

        User currentUser = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("currentUser", currentUser);

        return "add_group_page";
    }

    @PostMapping("/addGroup")
    public String addGroup(@ModelAttribute Group form) {
        groupsService.saveGroup(form);
        return "redirect:/groups";
    }
    @GetMapping("/groups/delete/{group-id}")
    public String getDeleteGroup(@PathVariable("group-id") Long groupId) {
        groupsService.deleteGroup(groupId);
        return "redirect:/groups";
    }
}
