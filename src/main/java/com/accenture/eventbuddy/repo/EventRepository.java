package com.accenture.eventbuddy.repo;

import com.accenture.eventbuddy.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
