package com.accenture.eventbuddy.services;
//
//import com.accenture.eventbuddy.auth.User;
//import com.accenture.eventbuddy.models.Organizer;
//import com.accenture.eventbuddy.models.Visitor;
//import com.accenture.eventbuddy.repo.VisitorRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class VisitorService {
//    VisitorRepository visitorRepository;
//
//    public VisitorService(VisitorRepository visitorRepository) {
//        this.visitorRepository = visitorRepository;
//    }
//
//    public void deleteById(Long id){
//        visitorRepository.deleteById(id);
//    }
//
//
//    public List<Visitor> all(){
//        return (List<Visitor>) visitorRepository.findAll();
//    }
//
//    public void updateVisitor(Visitor visitor){
//        visitorRepository.save(visitor);
//    }
//
//    public void storeVisitor(Visitor visitor) {
//        visitorRepository.save(visitor);
//    }
//
//    public Visitor getById(Long id) {
//        return visitorRepository.findById(id).get();
//    }
//
//    public Visitor getByUser(User user) {
//        return visitorRepository.findByUser(user);
//    }
//
//}
