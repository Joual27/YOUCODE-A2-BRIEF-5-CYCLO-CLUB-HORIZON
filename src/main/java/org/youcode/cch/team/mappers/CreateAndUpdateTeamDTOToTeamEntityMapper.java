package org.youcode.cch.team.mappers;
import org.mapstruct.Mapper;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.team.DTOs.CreateAndUpdateTeamDTO;
import org.youcode.cch.team.Team;

@Mapper(componentModel = "spring")
public interface CreateAndUpdateTeamDTOToTeamEntityMapper extends BaseMapper<Team , CreateAndUpdateTeamDTO> {
}
