package com.accenture.eventbuddy.contracts;

import com.accenture.eventbuddy.models.Event;

import java.util.List;

public interface EventServiceContract {
    void storeEvent(Event event);

    Event getById(Long id);

    List<Event> all();

    void deleteById(Long id);
}
