package org.youcode.cch.team.mappers;

import org.mapstruct.Mapper;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.team.DTOs.EmbeddedTeamDTO;
import org.youcode.cch.team.Team;


@Mapper(componentModel = "spring")
public interface TeamEntityToTeamEmbeddedDTOMapper extends BaseMapper<Team , EmbeddedTeamDTO> {
}
