package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.models.Organizer;
import com.accenture.eventbuddy.repo.OrganizerRepository;

import java.util.List;

public class OrganizerService {

    OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public void storeOrganizer(Organizer organizer) {
        organizerRepository.save(organizer);
    }

    public Organizer getById(Long id){
        return organizerRepository.findById(id).orElse(null);
    }

    public List<Organizer> all(){ return (List<Organizer>) organizerRepository.findAll();}

    public void deleteById(Long id){ organizerRepository.deleteById(id);}
}
