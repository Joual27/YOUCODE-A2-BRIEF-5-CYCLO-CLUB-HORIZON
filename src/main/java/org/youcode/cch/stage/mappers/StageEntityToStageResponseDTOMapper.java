package org.youcode.cch.stage.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.cch.competition.mappers.EmbeddedCompetitionDTOToCompetitionEntityMapper;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.stage.DTOs.StageResponseDTO;
import org.youcode.cch.stage.Stage;

@Mapper(componentModel = "spring" , uses = EmbeddedCompetitionDTOToCompetitionEntityMapper.class)
public interface StageEntityToStageResponseDTOMapper extends BaseMapper<Stage , StageResponseDTO> {

    @Mapping(source = "isCompleted" , target = "isCompleted")
    @Mapping(source = "competition" , target = "competition")
    StageResponseDTO entityToDto(Stage s);
}
