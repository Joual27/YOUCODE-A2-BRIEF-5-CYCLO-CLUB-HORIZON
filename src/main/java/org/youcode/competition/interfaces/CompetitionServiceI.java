package org.youcode.competition.interfaces;

import org.youcode.competition.Competition;

import java.util.List;

public interface CompetitionServiceI {
    List<Competition> getAllCompetitions();
    Competition getCompetitionById(Long id);
    Competition save(Competition c);
    Competition update(Competition c);
    Competition deleteById(Long id);
}
