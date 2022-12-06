package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.repo.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void storeEvent(Event event) {
        eventRepository.save(event);
    }

    public Event getById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> all(){ return (List<Event>) eventRepository.findAll();}

    public void deleteById(Long id){ eventRepository.deleteById(id);}




}
