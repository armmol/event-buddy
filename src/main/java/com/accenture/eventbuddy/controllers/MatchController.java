package com.accenture.eventbuddy.controllers;


import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.models.Match;
import com.accenture.eventbuddy.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "match")
public class MatchController {

    @Autowired
    private MatchService matchService;


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



}
