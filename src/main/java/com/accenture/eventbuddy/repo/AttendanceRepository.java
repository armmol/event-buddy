package com.accenture.eventbuddy.repo;

import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.models.UserReplica;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    Optional<Attendance> findByEventAndUserReplica(Event event, UserReplica userReplica);
}

