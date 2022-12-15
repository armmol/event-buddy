package com.accenture.eventbuddy.services;
//
//import com.accenture.eventbuddy.auth.User;
//import com.accenture.eventbuddy.contracts.UserServiceContract;
//import com.accenture.eventbuddy.repo.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService implements UserServiceContract {
//    UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public List<User> all() {
//        return (List<User>) userRepository.findAll();
//    }
//
//    @Override
//    public User getById(Long id) {
//        return userRepository.findById(id).get();
//    }
//}
