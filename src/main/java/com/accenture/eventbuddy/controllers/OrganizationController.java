package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "organizer")
public class OrganizationController {

    @Autowired
    private OrganizerService organizerService;

    @PostMapping("/createEvent")
    public void createEvent(){

    }
}
