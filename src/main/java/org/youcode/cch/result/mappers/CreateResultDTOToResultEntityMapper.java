package org.youcode.cch.result.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.Result;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.shared.interfaces.BaseMapper;
import org.youcode.cch.stage.Stage;

@Mapper(componentModel = "spring")
public abstract class CreateResultDTOToResultEntityMapper implements BaseMapper<Result , CreateResultDTO> {

    @Mapping(target = "id" , expression = "java(generateResultKey(c.getStageId(), c.getCyclistId()))")
    @Mapping(target = "stage.id" , source = "stageId")
    @Mapping(target = "cyclist.id" , source = "cyclistId")
    public abstract Result toEntity(CreateResultDTO c );

    protected  ResultKey generateResultKey (Long stageId , Long cyclistId){
        return new ResultKey(stageId,cyclistId);
    }


}
