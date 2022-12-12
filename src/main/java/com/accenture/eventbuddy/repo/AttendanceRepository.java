package com.accenture.eventbuddy.repo;

import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.models.Gender;
import com.accenture.eventbuddy.models.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

}

