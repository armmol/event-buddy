package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.models.Organizer;
import com.accenture.eventbuddy.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "event")
public class EventController {

    @Autowired
    private EventService eventService;

    //Add event GET
    @RequestMapping(value = {"/addEvent"}, method = RequestMethod.GET)
    public String showAddEventPage(@PathVariable Long id, Model model){
        Event event = new Event();
       // event.setOrganizer(OrganizerService.getById(id));
        model.addAttribute("event", event);
        return "addEvent";
    }

    //Add event POST
    @RequestMapping(value = {"/addEvent"}, method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("eventForm") Event event){
        Organizer organizer = event.getOrganizer();
        if(organizer != null ){
            event.setOrganizer(organizer);
            eventService.storeEvent(event);
            return "redirect:/showEvent/" + event.getEventId();
        }else return "redirect:/notFoundError";
    }

    //Delete event
    @RequestMapping(value = {"/deleteEvent"}, method = RequestMethod.POST)
    public String deleteEvent(@RequestParam Long id){
        eventService.deleteById(id);
        return "redirect:/eventList";
    }

    //Show event list
    @RequestMapping (value = {"eventList"}, method = RequestMethod.GET)
    public String events(Model model){
        List<Event> events = eventService.all();
        model.addAttribute("events", events);
        return "eventList";
    }

    //Show specific event
    @RequestMapping (value = {"/showEvent/{id}"}, method = RequestMethod.GET)
    public String event(@PathVariable("id") Long id, Model model){
        Event event = eventService.getById(id);
        model.addAttribute("event", event);
        model.addAttribute("attendances", event.getAttendances());
        return "showEvent";
    }

}
