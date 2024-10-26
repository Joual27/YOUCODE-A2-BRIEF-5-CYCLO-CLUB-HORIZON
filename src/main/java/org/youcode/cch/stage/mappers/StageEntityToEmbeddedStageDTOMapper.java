package org.youcode.cch.stage.mappers;

import org.mapstruct.Mapper;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.stage.DTOs.EmbeddedStageDTO;
import org.youcode.cch.stage.Stage;

@Mapper(componentModel = "spring")
public interface StageEntityToEmbeddedStageDTOMapper extends BaseMapper<Stage, EmbeddedStageDTO> {
}
