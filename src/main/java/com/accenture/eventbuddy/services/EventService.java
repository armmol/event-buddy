package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.repo.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void storeEvent(Event event) {
        eventRepository.save(event);
    }
}
