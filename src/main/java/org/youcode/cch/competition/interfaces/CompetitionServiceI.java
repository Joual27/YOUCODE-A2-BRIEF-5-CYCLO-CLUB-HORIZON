package org.youcode.cch.competition.interfaces;

import org.youcode.cch.competition.Competition;

import java.util.List;

public interface CompetitionServiceI {
    List<Competition> getAllCompetitions();
    Competition getCompetitionEntityById(Long id);
    Competition save(Competition c);
    Competition update(Competition c);
    Competition deleteById(Long id);
}
