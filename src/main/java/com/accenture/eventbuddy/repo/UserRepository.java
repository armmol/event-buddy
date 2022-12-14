package com.accenture.eventbuddy.repo;

import com.accenture.eventbuddy.auth.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
