package com.accenture.eventbuddy;

import com.accenture.eventbuddy.models.Address;
import com.accenture.eventbuddy.models.Event;
import com.accenture.eventbuddy.models.Genre;
import com.accenture.eventbuddy.models.Organizer;
import com.accenture.eventbuddy.repo.EventRepository;
import com.accenture.eventbuddy.services.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class EventServiceTest {

    @Autowired
    EventService eventService;

    @Autowired
    EventRepository eventRepository;

    @Test
    public void saveAndGetEvent() {
        Event event = new Event();
        event.setName("event");
        event.setDescription("description");
        event.setStartDate(Date.valueOf("2022-01-01"));
        event.setEndDate(Date.valueOf("2022-02-01"));
        event.setGenre(Genre.FESTIVAL);
        Address address = new Address();
        address.setCity("Valka");
        address.setCountry("Latvia");
        event.setAddress(address);
        Organizer organizer = new Organizer();
        organizer.setOrganizerEmail("e@mail.com");
        organizer.setOrganizerName("Organizer");
        organizer.setPhoneNumber("+37122222222");
        event.setOrganizer(organizer);

        eventService.storeEvent(event);

        Long storedEventId = event.getEventId();

        Event eventFromDatabase = eventRepository.findById(storedEventId).get();

        assert event.getName().equals(eventFromDatabase.getName());
    }
}