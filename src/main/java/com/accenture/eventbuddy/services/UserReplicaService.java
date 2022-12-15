package com.accenture.eventbuddy.services;

import com.accenture.eventbuddy.models.UserReplica;
import com.accenture.eventbuddy.repo.UserReplicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReplicaService {
    private UserReplicaRepository userReplicaRepository;
    public UserReplicaService(UserReplicaRepository userReplicaRepository) {
        this.userReplicaRepository = userReplicaRepository;
    }

    public void deleteById(Long id){
        userReplicaRepository.deleteById(id);
    }


    public List<UserReplica> all(){
        return (List<UserReplica>) userReplicaRepository.findAll();
    }

    public void updateUserReplica(UserReplica userReplica){
        userReplicaRepository.save(userReplica);
    }

    public void storeUserReplica(UserReplica userReplica) {
        userReplicaRepository.save(userReplica);
    }

    public UserReplica getById(Long id) {
        return userReplicaRepository.findById(id).get();
    }
    
}
