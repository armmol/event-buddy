package com.accenture.eventbuddy.repo;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.models.Visitor;
import org.springframework.data.repository.CrudRepository;

public interface VisitorRepository extends CrudRepository<Visitor, Long> {
    Visitor findByUser(User user);
}
