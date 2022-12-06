package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.repo.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public void storeAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    public Attendance getById(Long id){
        return attendanceRepository.findById(id).orElse(null);
    }

    public List<Attendance> all(){ return (List<Attendance>) attendanceRepository.findAll();}

    public void deleteById(Long id){ attendanceRepository.deleteById(id);}



}
