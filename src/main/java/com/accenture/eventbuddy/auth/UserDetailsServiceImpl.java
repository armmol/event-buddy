package com.accenture.eventbuddy.auth;

import com.accenture.eventbuddy.models.Organizer;
import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.repo.OrganizerRepository;
import com.accenture.eventbuddy.repo.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        if (userDto.getRole() == UserRole.VISITOR) {
            Visitor visitor = userDto.getVisitor();
            visitor.setUser(user);
            visitorRepository.save(visitor);
        } else if (userDto.getRole() == UserRole.ORGANIZER) {
            Organizer organizer = userDto.getOrganizer();
            organizer.setUser(user);
            organizerRepository.save(organizer);
        }
    }
}
