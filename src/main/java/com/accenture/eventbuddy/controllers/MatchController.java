package com.accenture.eventbuddy.controllers;


import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.models.Match;
import com.accenture.eventbuddy.models.UserReplica;
import com.accenture.eventbuddy.services.MatchService;
import com.accenture.eventbuddy.services.UserReplicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    UserReplicaService userReplicaService;

    @RequestMapping(value = {"/addMatch"}, method = RequestMethod.GET)
    public String addMatch(@PathVariable Long id, Model model) {
        Match match = new Match();
        model.addAttribute("match", match);
        return "addMatch";
    }

    //Add attendance POST
    @RequestMapping(value = {"/addMatch"}, method = RequestMethod.POST)
    public String saveMatch(@ModelAttribute("attendanceForm") Match match) {
        matchService.storeMatch(match);
        return "redirect:/event/eventList";
    }

    @GetMapping("/{id}/matches")
    public String getAllMatches(@PathVariable Long id, Model model) {
        UserReplica user = userReplicaService.getById(id);
        for (UserReplica userReplica : userReplicaService.all()) {
            if (userReplica.getId().equals(id)) {
                List<Match> visitorMatches = matchService.findListOfMatchesForSpecificVisitor(id);
                visitorMatches.forEach(i -> {
                    Attendance tempAttendance;
                    if (i.getAttendance1().getUserReplica().getId().equals(id)) {
                        tempAttendance = i.getAttendance2();
                        i.setAttendance2(i.getAttendance1());
                        i.setAttendance1(tempAttendance);
                    }
                });

                model.addAttribute("visitorMatches", visitorMatches);
                model.addAttribute("userId", id);
                return "matches";
            }
        }
        return "redirect:/registration/login";
    }

    @GetMapping("/add/{visitorId}/{attendanceId}")
    public String createMatch(
            @PathVariable(name = "visitorId") Long visitorId,
            @PathVariable(name = "attendanceId") Long attendanceId) {
        matchService.findOrCreateMatch(visitorId, attendanceId);
        return "redirect:/match/" + visitorId + "/matches";
    }
}
