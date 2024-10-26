package org.youcode.cch.result.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.cch.cyclist.mappers.CyclistEntityToEmbeddedCyclistDTOMapper;
import org.youcode.cch.result.DTOs.ResultResponseDTO;
import org.youcode.cch.result.Result;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.stage.mappers.StageEntityToEmbeddedStageDTOMapper;

@Mapper(componentModel = "spring" , uses = {StageEntityToEmbeddedStageDTOMapper.class, CyclistEntityToEmbeddedCyclistDTOMapper.class})
public interface ResultEntityToResultResponseDTOMapper extends BaseMapper<Result , ResultResponseDTO> {
}


