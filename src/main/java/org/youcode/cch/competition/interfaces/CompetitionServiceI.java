package org.youcode.cch.competition.interfaces;

import org.youcode.cch.competition.Competition;
import org.youcode.cch.competition.DTOs.CompetitionResponseDTO;
import org.youcode.cch.competition.DTOs.CreateAndUpdateCompetitionDTO;

import java.util.List;

public interface CompetitionServiceI {
    List<CompetitionResponseDTO> getAllCompetitions();
    Competition getCompetitionEntityById(Long id);
    CompetitionResponseDTO save(CreateAndUpdateCompetitionDTO c);
    CompetitionResponseDTO update(CreateAndUpdateCompetitionDTO c , Long Id);
    CompetitionResponseDTO getById(Long id);
    CompetitionResponseDTO deleteById(Long id);
}
