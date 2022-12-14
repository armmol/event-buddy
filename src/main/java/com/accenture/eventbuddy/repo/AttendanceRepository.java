package com.accenture.eventbuddy.repo;

import com.accenture.eventbuddy.models.*;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    Optional<Attendance> findByEventAndVisitor(Event event, Visitor visitor);
}

