package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.models.TypeUser;
import com.accenture.eventbuddy.models.UserReplica;
import com.accenture.eventbuddy.services.UserReplicaService;
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
    private UserReplicaService userReplicaService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        TypeUser user = new TypeUser();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/register/saveVisitor")
    public String saveVisitor(@ModelAttribute("user") TypeUser user) {
        UserReplica userReplica = user.isUserReplica();
        userReplicaService.storeUserReplica(userReplica);
        System.out.println("Visitor");
        return "redirect:/event/" + userReplica.getId() + "/eventList";
    }

//    @PostMapping("/register/saveOrganizer")
//    public String saveOrganizer(@ModelAttribute("user") TypeUser user) {
//        Organizer organizer = user.isOrganizer();
//        organizerService.storeOrganizer(user.isOrganizer());
//        System.out.println("Organizer");
//        return "redirect:/event/" + organizer.getUser().getId() + "/eventList";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        UserReplica userReplica = new UserReplica();
        model.addAttribute("user", userReplica);
        return "login";
    }

    @PostMapping("/login/check")
    public String loginVisitor(@ModelAttribute("user") UserReplica userReplica) {
        for (UserReplica userLooper : userReplicaService.all()) {
            if (userLooper.equals(userReplica))
                return "redirect:/event/" + userLooper.getId() + "/eventList";
        }
        return "login";
    }
}
