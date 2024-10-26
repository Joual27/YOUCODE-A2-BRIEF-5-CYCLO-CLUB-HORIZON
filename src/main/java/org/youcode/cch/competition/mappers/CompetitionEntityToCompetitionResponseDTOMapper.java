package org.youcode.cch.competition.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.cch.competition.Competition;
import org.youcode.cch.competition.DTOs.CompetitionResponseDTO;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.stage.mappers.StageEntityToEmbeddedStageDTOMapper;

@Mapper(componentModel = "spring" , uses = StageEntityToEmbeddedStageDTOMapper.class)
public abstract class CompetitionEntityToCompetitionResponseDTOMapper implements BaseMapper<Competition , CompetitionResponseDTO>{

    @Override
    @Mapping(source = "stages" , target = "stages")
    public abstract Competition toEntity(CompetitionResponseDTO dto);
}
