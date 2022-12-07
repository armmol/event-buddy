package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.repo.VisitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository){
        this.visitorRepository = visitorRepository;
    }

    public void storeVisitor(Visitor visitor){
        visitorRepository.save(visitor);
    }

    public Visitor getById(Long id){
        return visitorRepository.findById(id).orElse(null);
    }

    public List<Visitor> all(){
        return (List<Visitor>) visitorRepository.findAll();
    }

    public void deleteById(Long id){
        visitorRepository.deleteById(id);
    }
}
