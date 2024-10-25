package org.youcode.cch.result.DTOs;

import jakarta.validation.constraints.NotNull;

import java.time.Duration;

public class CreateResultDTO {
    @NotNull
    private Long stageId;
    @NotNull
    private Long cyclistId;
    private Duration time;

    public CreateResultDTO(){}
    public CreateResultDTO(Long stageId , Long cyclistId , Duration time){
        this.cyclistId = cyclistId;
        this.stageId = stageId;
        this.time = time;
    }

    public Long getStageId() {
        return stageId;
    }
    public Long getCyclistId() {
        return cyclistId;
    }
    public Duration getTime() {
        return time;
    }
}
