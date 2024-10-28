package org.youcode.cch.team.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.DTOs.EmbeddedCyclistDTO;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.cyclist.mappers.CyclistEntityToEmbeddedCyclistDTOMapper;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.team.DTOs.TeamResponseDTO;
import org.youcode.cch.team.Team;

import java.util.List;

@Mapper(componentModel = "spring" )
public abstract class TeamEntityToTeamResponseDTOMapper implements BaseMapper<Team , TeamResponseDTO> {

    @Autowired
    private  CyclistDaoI cyclistDao;

    @Autowired
    private CyclistEntityToEmbeddedCyclistDTOMapper cyclistEntityToEmbeddedCyclistDTOMapper;

    @Mapping(target = "members" , expression = "java(getMembersOfTeam(t))")
    public abstract TeamResponseDTO entityToDto(Team t);

    protected List<EmbeddedCyclistDTO> getMembersOfTeam(Team t){
        List<Cyclist> res = cyclistDao.getCyclistsOfTeam(t);
        return res.stream()
                .map(cyclistEntityToEmbeddedCyclistDTOMapper::entityToDto)
                .toList();
    }

}
