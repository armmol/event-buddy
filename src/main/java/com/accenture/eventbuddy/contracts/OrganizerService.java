package com.accenture.eventbuddy.contracts;

import com.accenture.eventbuddy.models.Organizer;

import java.util.List;

public interface OrganizerService {
    void storeOrganizer(Organizer organizer);

    Organizer getById(Long id);

    List<Organizer> all();

    void deleteById(Long id);
}
