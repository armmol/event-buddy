package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.contracts.EventServiceContract;
import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.repo.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements EventServiceContract {

    EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void storeEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event getById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public List<Event> all() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }


}
