package org.youcode.cch.generalResult.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.cch.competition.mappers.EmbeddedCompetitionDTOToCompetitionEntityMapper;
import org.youcode.cch.cyclist.mappers.CyclistEntityToEmbeddedCyclistDTOMapper;
import org.youcode.cch.generalResult.DTOs.GeneralResultResponseDTO;
import org.youcode.cch.generalResult.GeneralResult;
import org.youcode.cch.shared.interfaces.BaseMapper;

@Mapper(componentModel = "spring" , uses = {EmbeddedCompetitionDTOToCompetitionEntityMapper.class , CyclistEntityToEmbeddedCyclistDTOMapper.class})
public interface GeneralResultEntityToGeneralResultResponseDTOMapper extends BaseMapper<GeneralResult , GeneralResultResponseDTO>{

    @Mapping(source = "competition" , target = "competition")
    @Mapping(source = "cyclist" , target = "cyclist")
    GeneralResultResponseDTO entityToDto(GeneralResult entity);
}
