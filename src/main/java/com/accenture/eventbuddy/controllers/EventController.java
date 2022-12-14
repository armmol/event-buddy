package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.models.Gender;
import com.accenture.eventbuddy.models.Language;
import com.accenture.eventbuddy.services.AttendanceService;
import com.accenture.eventbuddy.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private AttendanceService attendanceService;

    //Add event GET
    @RequestMapping(value = {"/addEvent"}, method = RequestMethod.GET)
    public String showAddEventPage(@PathVariable Long id, Model model) {
        Event event = new Event();
        // event.setOrganizer(OrganizerService.getById(id));
        model.addAttribute("event", event);
        return "addEvent";
    }

    //Add event POST
    @RequestMapping(value = {"/addEvent"}, method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("eventForm") Event event) {
        eventService.storeEvent(event);
        return "redirect:showEvent/" + event.getEventId();
    }

    //Delete event
    @RequestMapping(value = {"/deleteEvent"}, method = RequestMethod.POST)
    public String deleteEvent(@RequestParam Long id) {
        eventService.deleteById(id);
        return "redirect:eventList";
    }

    //Show event list
    @RequestMapping(value = {"/{userId}/eventList"}, method = RequestMethod.GET)
    public String events(@PathVariable("userId") Long userId, Model model) {
        List<Event> events = eventService.all();
        model.addAttribute("userId", userId);
        model.addAttribute("events", events);
        return "eventList";
    }

    //Show specific event
    @RequestMapping(value = {"/{visitorId}/showEvent/{id}/{gender}/{language}/{dateOfBirth}"}, method = RequestMethod.GET)
    public String event(@PathVariable("visitorId") Long visitorId, @PathVariable("id") Long id, @PathVariable("gender") Gender gender, @PathVariable("language") Language language, @PathVariable("dateOfBirth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth, Model model) {
        Event event = eventService.getById(id);
        model.addAttribute("event", event);
        model.addAttribute("visitorId", visitorId);
        model.addAttribute("attendances", attendanceService.getMatchingAttendanceList(event, gender, language, dateOfBirth));
        return "showEvent";
    }

    @RequestMapping(value = {"/showEvent/{id}"}, method = RequestMethod.GET)
    public String showEvent(@PathVariable("id") Long id, Model model) {
        Event event = eventService.getById(id);
        model.addAttribute("event", event);
        model.addAttribute("attendances", event.getAttendances());
        return "showEvent";
    }

}
