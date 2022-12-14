package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.UserDetailsServiceImpl;
import com.accenture.eventbuddy.models.TypeUser;
import com.accenture.eventbuddy.services.OrganizerService;
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
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private OrganizerService organizerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        TypeUser user = new TypeUser();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/register/saveVisitor")
    public String saveVisitor(@ModelAttribute ("user") TypeUser user){
        visitorService.storeVisitor(user.isVisitor());
        return "redirect:/event/eventList";
    }
    @PostMapping("/register/saveOrganizer")
    public String saveOrganizer(@ModelAttribute ("user") TypeUser user){
        organizerService.storeOrganizer(user.isOrganizer());
        return "redirect:/event/eventList";
    }
}
