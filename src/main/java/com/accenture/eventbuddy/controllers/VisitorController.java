package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.UserRole;
import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.models.UserReplica;
import com.accenture.eventbuddy.repo.UserReplicaRepository;
import com.accenture.eventbuddy.services.EventService;
import com.accenture.eventbuddy.services.UserReplicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/visitor")
public class VisitorController {
    @Autowired
    private UserReplicaRepository userReplicaRepository;
    
    @Autowired
    private UserReplicaService userReplicaService;
    @Autowired
    private EventService eventService;

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addUserReplica(Model model) {
        model.addAttribute("visitor", new UserReplica());
        return "visitor/add";
    }

    @PostMapping("/add")
    public String addUserReplica(@ModelAttribute UserReplica visitor) {
        userReplicaService.storeUserReplica(visitor);
        return "redirect:/visitor/all";
    }

    @GetMapping("/all")
    public String allUserReplicas(Model model) {
        List<UserReplica> visitors = userReplicaService.all();
        model.addAttribute("visitors", visitors);
        return "visitor/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserReplica(@PathVariable Long id) {
        userReplicaService.deleteById(id);
        return "redirect:/visitor/all";
    }

    @GetMapping("/edit/{id}")
    public String editUserReplica(@PathVariable Long id, Model model) {
        UserReplica userReplica = userReplicaService.getById(id);
        model.addAttribute("visitor", userReplica);
        return "visitor/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUserReplica(@PathVariable Long id, @ModelAttribute UserReplica visitor) {
        userReplicaService.updateUserReplica(visitor);
        return "redirect:/visitor/all";
    }

    @GetMapping("/details/{id}")
    public String detailsUserReplica(@PathVariable Long id, Model model) {
        UserReplica visitor = userReplicaService.getById(id);
        model.addAttribute("visitor", visitor);
        return "visitor/details";
    }

    @RequestMapping(value = {"visitorList"}, method = RequestMethod.GET)
    public String visitors(Model model) {
        List<UserReplica> visitors = userReplicaService.all();
        model.addAttribute("visitors", visitors);
        return "visitorList";
    }

    @RequestMapping(value = {"/showUserReplica/{id}"}, method = RequestMethod.GET)
    public String showUserReplica(@PathVariable("id") Long id, Model model) {
        UserReplica visitor = userReplicaService.getById(id);
        model.addAttribute("visitor", visitor);
        return "showUserReplica";
    }


    @RequestMapping(value = {"/{id}/visitorProfile"}, method = RequestMethod.GET)
    public String showEditUserReplicaProfilePage(Model model, @PathVariable Long id) {
        Optional<UserReplica> user = userReplicaRepository.findById(id);
        model.addAttribute("user", id);
        if (user.isPresent()) {
            UserRole role = user.get().getRole();
            if (role == UserRole.VISITOR) {
                for (UserReplica userReplica : userReplicaService.all()) {
                    if (userReplica.getId().equals(id)) {
                        model.addAttribute("visitor", userReplica);
                        return "visitor/show";
                    }
                }
            } else {
                for (UserReplica userReplica : userReplicaService.all()) {
                    if (userReplica.getId().equals(id)) {
                        model.addAttribute("organizer", userReplica);
                        return "organizer/show";
                    }
                }
            }
            return "registration";
        }
        return "registration";
    }


    @RequestMapping(value = {"/{id}/visitorProfile/personal"}, method = RequestMethod.GET)
    public String showProfilePersonalPage(Model model, @PathVariable Long id) {
        Optional<UserReplica> user = userReplicaRepository.findById(id);
        model.addAttribute("userId", id);
        if (user.isPresent()) {
            UserRole role = user.get().getRole();
            if (role == UserRole.VISITOR) {
                for (UserReplica userReplica : userReplicaService.all()) {
                    if (userReplica.getId().equals(id)) {
                        model.addAttribute("visitor", userReplica);
                        return "visitor/showPersonal";
                    }
                }
            } else {

                for (UserReplica userReplica : userReplicaService.all()) {
                    if (userReplica.getId().equals(id)) {
                        List<Event> events = eventService.all();
                        model.addAttribute("events", events.stream().
                                filter(event -> event.getUserReplica().getId().equals(id))
                                .collect(Collectors.toList()));
                        model.addAttribute("organizer", userReplica);
                        return "organizer/showPersonal";
                    }
                }
            }
            return "registration";
        }
        return "registration";
    }

    @RequestMapping(value = {"/{id}/visitorProfile/edit"}, method = RequestMethod.GET)
    public String showEditUserReplicaProfilePage(Model model, @PathVariable Long id, Principal principal) {
        Optional<UserReplica> user = userReplicaRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("visitor", user.get());
            model.addAttribute("userId", id);
            return "visitor/edit";
        }
        return "registration/register";
    }

    @RequestMapping(value = {"/{id}/visitorProfile/edit"}, method = RequestMethod.POST)
    public String editUserReplicaProfile(@ModelAttribute("visitor") UserReplica userReplica, BindingResult result, Model model, @PathVariable Long id) {
        if (result.hasErrors()) {
            userReplica.setId(id);
            return "visitor/edit";
        }
        UserReplica userReplica1 = userReplicaService.getById(id);
        userReplica1.setDescription(userReplica.getDescription());
        userReplicaService.updateUserReplica(userReplica1);
        model.addAttribute("user", id);
        return "redirect:/visitor/" + userReplica1.getId() + "/visitorProfile/personal";
    }
}
