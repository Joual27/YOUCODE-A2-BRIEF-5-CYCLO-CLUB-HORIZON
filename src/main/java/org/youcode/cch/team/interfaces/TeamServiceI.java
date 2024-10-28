package org.youcode.cch.team.interfaces;

import org.youcode.cch.team.DTOs.CreateAndUpdateTeamDTO;
import org.youcode.cch.team.DTOs.TeamResponseDTO;
import org.youcode.cch.team.Team;

import java.util.List;
import java.util.Optional;

public interface TeamServiceI {
    Team getTeamById(Long id);
    TeamResponseDTO save(CreateAndUpdateTeamDTO t);
    TeamResponseDTO update(CreateAndUpdateTeamDTO t , Long id);
    TeamResponseDTO getTeamResponseById(Long id);
    List<TeamResponseDTO> getAllTeams();
    TeamResponseDTO deleteById(Long id);
}
