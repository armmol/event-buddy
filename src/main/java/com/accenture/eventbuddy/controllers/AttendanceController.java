package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (path = "attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value = {"/addAttendance"}, method = RequestMethod.GET)
    public String addAttendance(@PathVariable Long id, Model model) {
        Attendance attendance = new Attendance();
        model.addAttribute("attendance", attendance);
        return "addAttendance";
    }

    //Add attendance POST
    @RequestMapping(value = {"/addAttendance"}, method = RequestMethod.POST)
    public String saveAttendance(@ModelAttribute("attendanceForm") Attendance attendance) {
        attendanceService.storeAttendance(attendance);
        return "redirect:/event/showEvent/" + attendance.getEvent().getEventId();
    }



}
