package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.contracts.AttendanceServiceContract;
import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.models.Gender;
import com.accenture.eventbuddy.models.Language;
import com.accenture.eventbuddy.repo.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttendanceService implements AttendanceServiceContract {
    AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public void storeAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    public Attendance getById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Attendance> all() {
        return (List<Attendance>) attendanceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        attendanceRepository.deleteById(id);
    }

    public List<Attendance> getMatchingAttendanceList(Event event, Gender gender, Language language, Date dateOfBirth) {
        return event.getAttendances()
                .stream().filter(i ->
                        i.getVisitor().getGender() == gender
                                && i.getVisitor().getDateOfBirth().after(dateOfBirth)
                                && i.getVisitor().getVisitorLanguage() == language)
                .toList();
    }


}
