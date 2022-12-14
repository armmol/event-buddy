package com.accenture.eventbuddy.contracts;

import com.accenture.eventbuddy.models.Match;

import java.util.List;

public interface MatchServiceContract {

    void storeMatch(Match match);

    Match getById(Long id);

    List<Match> all();

    void deleteById(Long id);

    List<Match> findListOfMatchesForSpecificVisitor(Long visitorId);
}
