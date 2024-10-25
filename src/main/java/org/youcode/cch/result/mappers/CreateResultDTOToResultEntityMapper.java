package org.youcode.cch.result.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.Result;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.result.interfaces.ResultServiceI;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.stage.Stage;
import org.youcode.cch.stage.interfaces.StageDaoI;

@Mapper(componentModel = "spring")
public abstract class CreateResultDTOToResultEntityMapper implements BaseMapper<Result , CreateResultDTO> {
    @Autowired
    private ResultServiceI resultService;

    @Mapping(target = "id" , expression = "java(getId(c.getStageId , c.getCyclistId()))")
    @Mapping(target = "stage" , expression = "java(getStage(c.getStageId()))")
    @Mapping(target = "cyclist" , expression = "java(getCyclist(c.getCyclistId()))")
    public abstract Result toEntity(CreateResultDTO c);

    protected ResultKey getId(Long stageId , Long cyclistId){
        return resultService.generateResultKey(stageId,cyclistId);
    }

    protected Stage getStage(Long stageId){
        Stage s = new Stage();
        s.setId(stageId);
        return s;
    }
    protected Cyclist getCyclist(Long cyclistId){
        Cyclist c = new Cyclist();
        c.setId(cyclistId);
        return c;
    }


}
