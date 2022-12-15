package com.accenture.eventbuddy.repo;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.models.Organizer;
import org.springframework.data.repository.CrudRepository;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {

    Organizer findByUser(User user);
}
