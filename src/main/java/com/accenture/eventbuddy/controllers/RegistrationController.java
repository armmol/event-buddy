package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.models.Organizer;
import com.accenture.eventbuddy.models.TypeUser;
import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.services.OrganizerService;
import com.accenture.eventbuddy.services.UserService;
import com.accenture.eventbuddy.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "registration")
public class RegistrationController {
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private OrganizerService organizerService;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        TypeUser user = new TypeUser();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/register/saveVisitor")
    public String saveVisitor(@ModelAttribute("user") TypeUser user) {
        Visitor visitor = user.isVisitor();
        visitorService.storeVisitor(visitor);
        System.out.println("Visitor");
        return "redirect:/event/" + visitor.getUser().getId() + "/eventList";
    }

    @PostMapping("/register/saveOrganizer")
    public String saveOrganizer(@ModelAttribute("user") TypeUser user) {
        Organizer organizer = user.isOrganizer();
        organizerService.storeOrganizer(user.isOrganizer());
        System.out.println("Organizer");
        return "redirect:/event/" + organizer.getUser().getId() + "/eventList";
    }

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login/check")
    public String loginVisitor(@ModelAttribute("user") User user) {
        for (User userLooper : userService.all()) {
            if (userLooper.equals(user))
                return "redirect:/event/" + userLooper.getId() + "/eventList";
        }
        return "login";
    }
}
