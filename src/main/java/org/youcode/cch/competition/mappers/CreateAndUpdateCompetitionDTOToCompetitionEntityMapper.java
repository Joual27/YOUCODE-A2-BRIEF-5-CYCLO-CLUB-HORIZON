package org.youcode.cch.competition.mappers;

import org.mapstruct.Mapper;
import org.youcode.cch.competition.Competition;
import org.youcode.cch.competition.DTOs.CreateAndUpdateCompetitionDTO;
import org.youcode.cch.shared.interfaces.BaseMapper;

@Mapper(componentModel = "spring")
public interface CreateAndUpdateCompetitionDTOToCompetitionEntityMapper extends BaseMapper<Competition , CreateAndUpdateCompetitionDTO> {
}
