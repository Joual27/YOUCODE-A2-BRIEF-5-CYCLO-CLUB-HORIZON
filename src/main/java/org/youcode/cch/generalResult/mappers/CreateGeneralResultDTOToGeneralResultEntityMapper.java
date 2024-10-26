package org.youcode.cch.generalResult.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.cch.generalResult.DTOs.CreateGeneralResultDTO;
import org.youcode.cch.generalResult.GeneralResult;
import org.youcode.cch.generalResult.embeddables.GeneralResultKey;
import org.youcode.cch.shared.interfaces.BaseMapper;

@Mapper(componentModel = "spring")
public abstract class CreateGeneralResultDTOToGeneralResultEntityMapper implements BaseMapper<GeneralResult , CreateGeneralResultDTO> {
    @Override
    @Mapping(target = "id" , expression = "java(generateId(dto.getCompetitionId(),dto.getCyclistId()))")
    @Mapping(target = "competition.id" , source = "competitionId")
    @Mapping(target = "cyclist.id" , source = "cyclistId")
    public abstract GeneralResult toEntity(CreateGeneralResultDTO dto);

    protected GeneralResultKey generateId(Long competitionId , Long cyclistId){
        return new GeneralResultKey(competitionId, cyclistId);
    }
}
