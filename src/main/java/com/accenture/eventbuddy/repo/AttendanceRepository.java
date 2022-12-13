package com.accenture.eventbuddy.repo;

import com.accenture.eventbuddy.models.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

}

