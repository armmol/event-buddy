package com.accenture.eventbuddy.services;


import com.accenture.eventbuddy.models.Match;
import com.accenture.eventbuddy.repo.AttendanceRepository;
import com.accenture.eventbuddy.repo.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    public void storeMatch (Match match){
        matchRepository.save(match);
    }

    public Match getById(Long id){
        return matchRepository.findById(id).orElse(null);
    }

    public List<Match> all(){
        return (List<Match>) matchRepository.findAll();
    }

    public void deleteById(Long id){
        matchRepository.findById(id);
    }




}