package com.accenture.eventbuddy.services;


import com.accenture.eventbuddy.contracts.MatchServiceContract;
import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.models.Match;
import com.accenture.eventbuddy.models.UserReplica;
import com.accenture.eventbuddy.repo.AttendanceRepository;
import com.accenture.eventbuddy.repo.MatchRepository;
import com.accenture.eventbuddy.repo.UserReplicaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService implements MatchServiceContract {

    private final MatchRepository matchRepository;
    private final AttendanceRepository attendanceRepository;
    private final UserReplicaRepository userReplicaRepository;

    public MatchService(MatchRepository matchRepository, AttendanceRepository attendanceRepository, UserReplicaRepository userReplicaRepository) {
        this.matchRepository = matchRepository;
        this.attendanceRepository = attendanceRepository;
        this.userReplicaRepository = userReplicaRepository;
    }

    @Override
    public void storeMatch(Match match) {
        matchRepository.save(match);
    }

    public Match findOrCreateMatch(Long userReplicaId, Long attendanceId) {
        List<Match> matches = (List<Match>) matchRepository.findAll();
        Match match = matches.stream().filter(i ->
                (
                        i.getAttendance1().getUserReplica().getId().equals(userReplicaId) &&
                                i.getAttendance2().getUserReplica().getId().equals(attendanceId)
//                        i.getAttendance1().getAttendanceId().equals(attendanceId) &&
//                                i.getAttendance2().getUserReplica().getId().equals(userReplicaId)
                ) ||
                        i.getAttendance2().getUserReplica().getId().equals(userReplicaId) &&
                                i.getAttendance1().getUserReplica().getId().equals(attendanceId)
//                        (i.getAttendance2().getAttendanceId().equals(attendanceId) &&
//                                i.getAttendance1().getUserReplica().getId().equals(attendanceId)))
        ).findFirst().orElse(null);
        if (match == null) {
            match = new Match();
            UserReplica userReplica = userReplicaRepository.findById(userReplicaId).orElse(null);
            Attendance secondAttendance = attendanceRepository.findById(attendanceId).orElse(null);
            Attendance callersAttendance = attendanceRepository.findByEventAndUserReplica(secondAttendance.getEvent(), userReplica).orElse(null);
            if (callersAttendance == null) {
                callersAttendance = new Attendance();
                callersAttendance.setUserReplica(userReplica);
                callersAttendance.setEvent(secondAttendance.getEvent());
            }
            match.setAttendance1(callersAttendance);
            match.setAttendance2(secondAttendance);
            matchRepository.save(match);
        }
        return match;
    }

    @Override
    public Match getById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    @Override
    public List<Match> all() {
        return (List<Match>) matchRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        matchRepository.findById(id);
    }

    @Override
    public List<Match> findListOfMatchesForSpecificVisitor(Long userReplicaId) {
        List<Match> visitorMatchList = new ArrayList<>();
        for (Match match : matchRepository.findAll()) {
            if (match.getAttendance1().getUserReplica().getId().equals(userReplicaId) ||
                    match.getAttendance2().getUserReplica().getId().equals(userReplicaId)) {
                visitorMatchList.add(match);
            }
        }
        return visitorMatchList;
    }
}