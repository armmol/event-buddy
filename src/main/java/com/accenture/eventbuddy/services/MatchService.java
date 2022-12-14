package com.accenture.eventbuddy.services;


import com.accenture.eventbuddy.models.Attendance;
import com.accenture.eventbuddy.models.Match;
import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.repo.AttendanceRepository;
import com.accenture.eventbuddy.repo.MatchRepository;
import com.accenture.eventbuddy.repo.VisitorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final AttendanceRepository attendanceRepository;
    private final VisitorRepository visitorRepository;

    public MatchService(MatchRepository matchRepository, AttendanceRepository attendanceRepository, VisitorRepository visitorRepository) {
        this.matchRepository = matchRepository;
        this.attendanceRepository = attendanceRepository;
        this.visitorRepository = visitorRepository;
    }

    public void storeMatch(Match match) {
        matchRepository.save(match);
    }

    public Match findOrCreateMatch(Long visitorId, Long attendanceId) {
        List<Match> matches = (List<Match>) matchRepository.findAll();
        Match match = matches.stream().filter(i ->
                (
                        i.getAttendance1().getAttendanceId().equals(attendanceId) &&
                                i.getAttendance2().getVisitor().getVisitorId().equals(visitorId)
                ) ||
                        (i.getAttendance2().getAttendanceId().equals(attendanceId) &&
                                i.getAttendance1().getVisitor().getVisitorId().equals(attendanceId)))
                .findFirst().orElse(null);
        if (match == null) {
            match = new Match();
            Visitor visitor = visitorRepository.findById(visitorId).orElse(null);
            Attendance secondAttendance = attendanceRepository.findById(attendanceId).orElse(null);
            Attendance callersAttendance = attendanceRepository.findByEventAndVisitor(secondAttendance.getEvent(), visitor).orElse(null);
            if (callersAttendance == null) {
                callersAttendance = new Attendance();
                callersAttendance.setVisitor(visitor);
                callersAttendance.setEvent(secondAttendance.getEvent());
            }
            match.setAttendance1(callersAttendance);
            match.setAttendance2(secondAttendance);
            matchRepository.save(match);
        }
        return match;
    }

    public Match getById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public List<Match> all() {
        return (List<Match>) matchRepository.findAll();
    }

    public void deleteById(Long id) {
        matchRepository.findById(id);
    }

    public List<Match> findListOfMatchesForSpecificVisitor(Long visitorId) {
        List<Match> visitorMatchList = new ArrayList<>();
        for (Match match : matchRepository.findAll()) {
            if (match.getAttendance1().getVisitor().getVisitorId().equals(visitorId) ||
                    match.getAttendance2().getVisitor().getVisitorId().equals(visitorId)) {
                visitorMatchList.add(match);
            }
        }
        return visitorMatchList;
    }
}