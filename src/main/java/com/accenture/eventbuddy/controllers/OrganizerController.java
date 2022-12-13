package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.models.Organizer;
import com.accenture.eventbuddy.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "organizer")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    //Add organizer POST
    @RequestMapping(value = {"/addOrganizer"}, method = RequestMethod.POST)
    public String saveOrganizer(@ModelAttribute("organizerForm") Organizer organizer) {
        if (organizer != null) {
            organizerService.storeOrganizer(organizer);
            return "redirect:/showOrganizer/" + organizer.getOrganizerId();
        } else return "redirect:/notFoundError";
    }

    //Delete organizer
    @RequestMapping(value = {"/deleteOrganizer"}, method = RequestMethod.POST)
    public String deleteOrganizer(@RequestParam Long organizerId) {
        organizerService.deleteById(organizerId);
        return "redirect:/organizerList";
    }

    //Show organizer list
    @RequestMapping(value = {"organizerList"}, method = RequestMethod.GET)
    public String organizers(Model model) {
        List<Organizer> organizers = organizerService.all();
        model.addAttribute("organizers", organizers);
        return "organizerList";
    }

    //Show specific organizer
    @RequestMapping(value = {"/showOrganizer/{organizerId}"}, method = RequestMethod.GET)
    public String organizer(@PathVariable("organizerId") Long organizerId, Model model) {
        Organizer organizer = organizerService.getById(organizerId);
        model.addAttribute("organizer", organizer);
        model.addAttribute("event", organizer.getEvent());
        return "showOrganizer";
    }
}
