package org.youcode.cch.team.interfaces;

import org.youcode.cch.team.DTOs.CreateAndUpdateTeamDTO;
import org.youcode.cch.team.DTOs.TeamResponseDTO;
import org.youcode.cch.team.Team;

import java.util.Optional;

public interface TeamServiceI {
    Team getTeamById(Long id);
    TeamResponseDTO save(CreateAndUpdateTeamDTO t);
}
