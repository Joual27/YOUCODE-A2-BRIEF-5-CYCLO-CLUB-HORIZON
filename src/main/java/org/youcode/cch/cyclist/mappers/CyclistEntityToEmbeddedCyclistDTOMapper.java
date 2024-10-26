package org.youcode.cch.cyclist.mappers;

import org.mapstruct.Mapper;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.DTOs.EmbeddedCyclistDTO;
import org.youcode.cch.shared.interfaces.BaseMapper;


@Mapper(componentModel = "spring")
public interface CyclistEntityToEmbeddedCyclistDTOMapper extends BaseMapper<Cyclist , EmbeddedCyclistDTO> {
}
