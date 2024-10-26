package org.youcode.cch.competition.mappers;

import org.mapstruct.Mapper;
import org.youcode.cch.competition.Competition;
import org.youcode.cch.competition.DTOs.CompetitionResponseDTO;
import org.youcode.cch.shared.interfaces.BaseMapper;

@Mapper(componentModel = "spring")
public abstract class CompetitionEntityToCompetitionResponseDTOMapper implements BaseMapper<Competition , CompetitionResponseDTO>{

    @Override
    public abstract Competition toEntity(CompetitionResponseDTO dto);
}
