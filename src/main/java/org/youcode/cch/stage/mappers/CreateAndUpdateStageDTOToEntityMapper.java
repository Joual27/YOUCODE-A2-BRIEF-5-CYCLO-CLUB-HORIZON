package org.youcode.cch.stage.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.youcode.cch.competition.Competition;
import org.youcode.cch.competition.interfaces.CompetitionServiceI;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.stage.DTOs.CreateAndUpdateStageDTO;
import org.youcode.cch.stage.Stage;

@Mapper(componentModel = "spring")
public abstract class CreateAndUpdateStageDTOToEntityMapper implements BaseMapper<Stage , CreateAndUpdateStageDTO>{
    @Autowired
    private CompetitionServiceI competitionService;

    @Override
    @Mapping(target = "competition" , expression = "java(getCompetitionById(dto.getCompetitionId()))")
    public abstract Stage toEntity(CreateAndUpdateStageDTO dto);

    protected Competition getCompetitionById(Long id){
        return competitionService.getCompetitionEntityById(id);
    }
}
