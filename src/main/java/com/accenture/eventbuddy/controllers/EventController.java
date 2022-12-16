package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.UserRole;
import com.accenture.eventbuddy.models.*;
import com.accenture.eventbuddy.repo.AttendanceRepository;
import com.accenture.eventbuddy.services.AttendanceService;
import com.accenture.eventbuddy.services.EventService;
import com.accenture.eventbuddy.services.MatchService;
import com.accenture.eventbuddy.services.UserReplicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private MatchService matchService;
    @Autowired
    private UserReplicaService userReplicaService;

    @Autowired
    private AttendanceRepository attendanceRepository;

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
        for (UserReplica user : userReplicaService.all()) {
            if (user.getId().equals(userId)) {
                if (user.getRole() == UserRole.VISITOR) {
                    model.addAttribute("events", events);
                    return "Visitor/eventList";
                } else {
                    model.addAttribute("events", events.stream().
                            filter(event -> event.getUserReplica().getId().equals(userId))
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
        model.addAttribute("filterData", new FilterAttendanceFormData());
        for (UserReplica userReplica : userReplicaService.all()) {
            if (userReplica.getId().equals(visitorId)) {
                List<Match> allMatches = matchService.all();
                if (userReplica.getRole() == UserRole.VISITOR) {
                    for (Attendance attendance : event.getAttendances()) {
                        if (attendance.getUserReplica().getId().equals(visitorId)) {
                            List<Attendance> filteredList = new ArrayList<>();
                            List<Match> newMatches = allMatches.stream().filter(match -> !match.getAttendance1().getAttendanceId().equals(attendance.getAttendanceId())
                                    || !match.getAttendance2().getAttendanceId().equals(attendance.getAttendanceId())).toList();

                            List<Long> attendanceIds = new ArrayList<>();
                            for (Match newMatch : newMatches) {
                                attendanceIds.add(newMatch.getAttendance1().getAttendanceId());
                                attendanceIds.add(newMatch.getAttendance2().getAttendanceId());
                            }
                            for (Long attendanceId : attendanceIds.stream().distinct().toList()) {
                                filteredList.add(attendanceService.getById(attendanceId));
                            }
                            model.addAttribute("attendances", filteredList);
                            return "Visitor/showEvent";
                        }
                    }
                    model.addAttribute("attendances", event.getAttendances());
                    return "visitor/showEventNotAttending";
                } else {
                    model.addAttribute("attendances", event.getAttendances());
                    return "Organizer/showEventOrganizer";
                }
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
        for (UserReplica user : userReplicaService.all()) {
            if (user.getId().equals(visitorId)) {
                if (user.getRole() == UserRole.VISITOR)
                    return "Visitor/showEvent";
                else
                    return "Organizer/showEventOrganizer";
            }
        }
        return "Visitor/showEvent";
    }

    @GetMapping("/{id1}/{id2}")
    public String interested(@PathVariable("id2") Long eventId,
                             @PathVariable("id1") Long visitorId, Model model) {
        Attendance attendance = new Attendance();
        attendance.setEvent(eventService.getById(eventId));
        attendance.setUserReplica(userReplicaService.getById(visitorId));
        attendanceService.storeAttendance(attendance);

        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);
        model.addAttribute("visitorId", visitorId);
        model.addAttribute("eventId", eventId);
        model.addAttribute("attendances", attendanceService.all().stream()
                .filter(attendance1 -> !attendance1.getUserReplica().getId().equals(visitorId)).toList());
        model.addAttribute("filterData", new FilterAttendanceFormData());
        return "Visitor/showEvent";
    }

    @PostMapping("/{id1}/{id2}")
    public String interestedPost(@ModelAttribute("filterData") FilterAttendanceFormData filterData,
                                 @PathVariable("id2") Long eventId,
                                 @PathVariable("id1") Long visitorId, Model model){
        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);
        model.addAttribute("visitorId", visitorId);
        model.addAttribute("attendances", attendanceService.getMatchingAttendanceList(
                event,
                filterData.getGender(),
                filterData.getLanguage(),
                filterData.getDateOfBirth()));
        model.addAttribute("filterData", new FilterAttendanceFormData());
        for (UserReplica user : userReplicaService.all()) {
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
