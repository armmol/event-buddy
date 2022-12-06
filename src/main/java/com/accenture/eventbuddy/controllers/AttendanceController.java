package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;




}
