package com.accenture.eventbuddy.services;

//import com.accenture.eventbuddy.auth.User;
//import com.accenture.eventbuddy.contracts.OrganizerServiceContract;
//import com.accenture.eventbuddy.models.Organizer;
//import com.accenture.eventbuddy.repo.OrganizerRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrganizerService implements OrganizerServiceContract {
//
//    private OrganizerRepository organizerRepository;
//
//    public OrganizerService(OrganizerRepository organizerRepository) {
//        this.organizerRepository = organizerRepository;
//    }
//
//    @Override
//    public void storeOrganizer(Organizer organizer) {
//        organizerRepository.save(organizer);
//    }
//
//    @Override
//    public Organizer getById(Long id) {
//        return organizerRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Organizer> all() {
//        return (List<Organizer>) organizerRepository.findAll();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        organizerRepository.deleteById(id);
//    }
//
//    @Override
//    public Organizer getByUser(User user) {
//        return organizerRepository.findByUser(user);
//    }
//}
