package org.youcode.cch.result.DTOs;

import jakarta.validation.constraints.NotNull;

import java.time.Duration;

public class CreateResultDTO {
    @NotNull
    private Long stageId;

    @NotNull
    private Long cyclistId;

    private Duration duration;


    public CreateResultDTO(){}
    public CreateResultDTO(Long stageId , Long cyclistId , Duration duration){
        this.cyclistId = cyclistId;
        this.stageId = stageId;
        this.duration = duration;
    }

    public Long getStageId() {
        return stageId;
    }
    public Long getCyclistId() {
        return cyclistId;
    }public Duration getDuration() {
        return duration;
    }
}
