package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.UserRole;
import com.accenture.eventbuddy.models.UserReplica;
import com.accenture.eventbuddy.services.UserReplicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "organizer")
public class OrganizerController {

    @Autowired
    private UserReplicaService userReplicaService;

    //Add userReplica POST
    @RequestMapping(value = {"/addOrganizer"}, method = RequestMethod.POST)
    public String saveOrganizer(@ModelAttribute("organizerForm") UserReplica userReplica) {
        if (userReplica != null) {
            userReplicaService.storeUserReplica(userReplica);
            return "redirect:/showOrganizer/" + userReplica.getId();
        } else return "redirect:/notFoundError";
    }

    //Delete organizer
    @RequestMapping(value = {"/deleteOrganizer"}, method = RequestMethod.POST)
    public String deleteOrganizer(@RequestParam Long organizerId) {
        userReplicaService.deleteById(organizerId);
        return "redirect:/organizerList";
    }

    //Show organizer list
    @RequestMapping(value = {"organizerList"}, method = RequestMethod.GET)
    public String organizers(Model model) {
        List<UserReplica> userReplicas = userReplicaService.all();
        model.addAttribute("userReplicas",
                userReplicas.stream().filter(userReplica -> userReplica.getRole()== UserRole.ORGANIZER).collect(Collectors.toList()));
        return "organizerList";
    }

    //Show specific organizer
    @RequestMapping(value = {"/showOrganizer/{userId}"}, method = RequestMethod.GET)
    public String organizer(@PathVariable("userReplicaId") Long userReplicaId, Model model) {
        UserReplica userReplica = userReplicaService.getById(userReplicaId);
        model.addAttribute("userReplica", userReplica);
        model.addAttribute("event", userReplica.getEvents());
        return "showOrganizer";
    }
}
