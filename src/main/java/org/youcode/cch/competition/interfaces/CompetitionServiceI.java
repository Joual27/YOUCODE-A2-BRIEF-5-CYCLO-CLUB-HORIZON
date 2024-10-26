package org.youcode.cch.competition.interfaces;

import org.youcode.cch.competition.Competition;
import org.youcode.cch.competition.DTOs.CompetitionResponseDTO;
import org.youcode.cch.competition.DTOs.CreateAndUpdateCompetitionDTO;

import java.util.List;

public interface CompetitionServiceI {
    List<Competition> getAllCompetitions();
    Competition getCompetitionEntityById(Long id);
    CompetitionResponseDTO save(CreateAndUpdateCompetitionDTO c);
Competition update(Competition c);
Competition deleteById(Long id);
}
