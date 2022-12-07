package com.accenture.eventbuddy.contracts;

import com.accenture.eventbuddy.models.Attendance;

import java.util.List;

public interface AttendanceServiceContract {
    void storeAttendance(Attendance attendance);

    Attendance getById(Long id);

    List<Attendance> all();

    void deleteById(Long id);
}
