package org.youcode.cch.cyclist.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.DTOs.CyclistResponseDTO;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.team.mappers.TeamEntityToTeamEmbeddedDTOMapper;

@Mapper(componentModel = "spring" , uses = TeamEntityToTeamEmbeddedDTOMapper.class)
public interface CyclistEntityToCyclistResponseDTOMapper extends BaseMapper<Cyclist , CyclistResponseDTO> {

    @Mapping(target = "team" , source = "team")
    CyclistResponseDTO entityToDto(Cyclist c);

}
