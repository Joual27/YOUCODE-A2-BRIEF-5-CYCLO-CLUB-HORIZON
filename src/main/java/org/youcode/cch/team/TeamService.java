package org.youcode.cch.team;

import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.team.DTOs.CreateAndUpdateTeamDTO;
import org.youcode.cch.team.DTOs.TeamResponseDTO;
import org.youcode.cch.team.interfaces.TeamDaoI;
import org.youcode.cch.team.interfaces.TeamServiceI;
import org.youcode.cch.team.mappers.CreateAndUpdateTeamDTOToTeamEntityMapper;
import org.youcode.cch.team.mappers.TeamEntityToTeamResponseDTOMapper;

import java.util.Optional;

public class TeamService implements TeamServiceI {

    private final TeamDaoI teamDao;
    private final CreateAndUpdateTeamDTOToTeamEntityMapper createAndUpdateTeamDTOToTeamEntityMapper;
    private final TeamEntityToTeamResponseDTOMapper teamEntityToTeamResponseDTOMapper;

    public TeamService(TeamDaoI teamDao , CreateAndUpdateTeamDTOToTeamEntityMapper createAndUpdateTeamDTOToTeamEntityMapper , TeamEntityToTeamResponseDTOMapper teamEntityToTeamResponseDTOMapper){
        this.teamDao = teamDao;
        this.createAndUpdateTeamDTOToTeamEntityMapper = createAndUpdateTeamDTOToTeamEntityMapper;
        this.teamEntityToTeamResponseDTOMapper = teamEntityToTeamResponseDTOMapper;
    }

    public Team getTeamById(Long id){
        Optional<Team> team = teamDao.findById(id);
        if (team.isEmpty()){
            throw new EntityNotFoundException("No Team found with given ID");
        }
        return team.get();
    }

    public TeamResponseDTO save(CreateAndUpdateTeamDTO t){
        Team teamToCreate = createAndUpdateTeamDTOToTeamEntityMapper.toEntity(t);
        System.out.println(teamToCreate.getName());
        Team createdTeam = teamDao.save(teamToCreate);
        return teamEntityToTeamResponseDTOMapper.entityToDto(createdTeam);
    }

}
