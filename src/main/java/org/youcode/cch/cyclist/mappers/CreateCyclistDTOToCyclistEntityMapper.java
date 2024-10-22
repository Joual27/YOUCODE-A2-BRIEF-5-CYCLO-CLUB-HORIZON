package org.youcode.cch.cyclist.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.DTOs.CreateCyclistDTO;
import org.youcode.cch.team.Team;
import org.youcode.cch.team.interfaces.TeamServiceI;


@Mapper(componentModel = "spring")
public abstract class CreateCyclistDTOToCyclistEntityMapper{
    @Autowired
    private TeamServiceI teamService;

    @Mapping(target = "team" , expression = "java(getTeamById(c.getTeamId()))")
    public abstract Cyclist toEntity(CreateCyclistDTO c);

    public abstract CreateCyclistDTO entityToDto(Cyclist c);

    protected Team getTeamById(Long id){
        return teamService.getTeamById(id);
    }
}
