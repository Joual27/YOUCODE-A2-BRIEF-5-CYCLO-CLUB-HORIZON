package org.youcode.cch.team;

import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.team.DTOs.CreateAndUpdateTeamDTO;
import org.youcode.cch.team.DTOs.TeamResponseDTO;
import org.youcode.cch.team.interfaces.TeamDaoI;
import org.youcode.cch.team.interfaces.TeamServiceI;
import org.youcode.cch.team.mappers.CreateAndUpdateTeamDTOToTeamEntityMapper;
import org.youcode.cch.team.mappers.TeamEntityToTeamResponseDTOMapper;

import java.util.List;
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

    @Override
    public Team getTeamById(Long id){
        Optional<Team> team = teamDao.findById(id);
        if (team.isEmpty()){
            throw new EntityNotFoundException("No Team found with given ID");
        }
        return team.get();
    }

    @Override
    public TeamResponseDTO save(CreateAndUpdateTeamDTO t){
        Team teamToCreate = createAndUpdateTeamDTOToTeamEntityMapper.toEntity(t);
        Team createdTeam = teamDao.save(teamToCreate);
        return teamEntityToTeamResponseDTOMapper.entityToDto(createdTeam);
    }

    @Override
    public TeamResponseDTO update(CreateAndUpdateTeamDTO t , Long id){
        Team teamToUpdate = createAndUpdateTeamDTOToTeamEntityMapper.toEntity(t);
        if (teamDao.findById(id).isEmpty()){
            throw new EntityNotFoundException("No team found with given ID");
        }
        else{
            teamToUpdate.setId(id);
            teamDao.update(teamToUpdate);
            return teamEntityToTeamResponseDTOMapper.entityToDto(teamToUpdate);
        }
    }

    @Override
    public TeamResponseDTO getTeamResponseById(Long id){
        Team t = teamDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No team found with given ID"));
        return teamEntityToTeamResponseDTOMapper.entityToDto(t);
    }

    @Override
    public List<TeamResponseDTO> getAllTeams(){
        List<Team> teams = teamDao.findAll();
        return teams.stream()
                .map(teamEntityToTeamResponseDTOMapper::entityToDto)
                .toList();
    }

    @Override
    public TeamResponseDTO deleteById(Long id){
        Team t = teamDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No team found with given ID"));
        teamDao.deleteById(id);
        return teamEntityToTeamResponseDTOMapper.entityToDto(t);
    }
}
