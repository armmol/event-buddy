package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.contracts.VisitorServiceContract;
import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.repo.VisitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService implements VisitorServiceContract {
    VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public void storeVisitor(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    @Override
    public Visitor getById(Long id) {
        return visitorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Visitor> all() {
        return (List<Visitor>) visitorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        visitorRepository.deleteById(id);
    }

    public Visitor getByUser(User user) {
        return visitorRepository.findByUser(user);
    }
}
