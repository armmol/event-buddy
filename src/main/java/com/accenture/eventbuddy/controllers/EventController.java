package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.auth.UserRole;
import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.models.FilterAttendanceFormData;
import com.accenture.eventbuddy.services.AttendanceService;
import com.accenture.eventbuddy.services.EventService;
import com.accenture.eventbuddy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private UserService userService;

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
    public String events(@PathVariable("userId") Long userId, Long userRole, Model model) {
        List<Event> events = eventService.all();
        model.addAttribute("userRole", userRole);
        model.addAttribute("userId", userId);
        for (User user : userService.all()) {
            if (user.getId().equals(userId)) {
                if (user.getRole() == UserRole.VISITOR) {
                    model.addAttribute("events", events);
                    return "Visitor/eventList";
                } else {
                    model.addAttribute("events", events.stream().
                            filter(event -> event.getOrganizer().getUser().getId().equals(userId))
                            .collect(Collectors.toList()));
                    return "Organizer/eventListOrganizer";
                }
            }
        }
        return "redirect:login";
    }

    @RequestMapping(value = {"/showEvent/{id}"}, method = RequestMethod.GET)
    public String showEvent(@PathVariable("id") Long id, Model model) {
        Event event = eventService.getById(id);
        model.addAttribute("event", event);
        model.addAttribute("attendances", event.getAttendances());
        return "showEvent";
    }

    @RequestMapping(value = {"/{visitorId}/showEvent/{id}"}, method = RequestMethod.GET)
    public String showVisitorsEvent(@PathVariable("id") Long eventId, @PathVariable("visitorId") Long visitorId, Model model) {
        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);
        model.addAttribute("visitorId", visitorId);
//        model.addAttribute("userId", visitorId);
        model.addAttribute("eventId", eventId);
        model.addAttribute("attendances", event.getAttendances());
        model.addAttribute("filterData", new FilterAttendanceFormData());
        for (User user : userService.all()) {
            if (user.getId().equals(visitorId)) {
                if (user.getRole() == UserRole.VISITOR)
                    return "Visitor/showEvent";
                else
                    return "Organizer/showEventOrganizer";
            }
        }
        return "showEvent";
    }

    @RequestMapping(value = {"/{visitorId}/showEvent/{id}"}, method = RequestMethod.POST)
    public String showFilteredVisitorsEvent(@ModelAttribute("filterData") FilterAttendanceFormData filterData, @PathVariable("id") Long eventId, @PathVariable("visitorId") Long visitorId, Model model) {
        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);
        model.addAttribute("visitorId", visitorId);
        model.addAttribute("attendances", attendanceService.getMatchingAttendanceList(
                event,
                filterData.getGender(),
                filterData.getLanguage(),
                filterData.getDateOfBirth()));
        model.addAttribute("filterData", new FilterAttendanceFormData());
        for (User user : userService.all()) {
            if (user.getId().equals(visitorId)) {
                if (user.getRole() == UserRole.VISITOR)
                    return "Visitor/showEvent";
                else
                    return "Organizer/showEventOrganizer";
            }
        }
        return "Visitor/showEvent";
    }


}
