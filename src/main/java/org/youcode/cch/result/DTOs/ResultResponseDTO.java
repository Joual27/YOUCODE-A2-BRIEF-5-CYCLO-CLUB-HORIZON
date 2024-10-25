package org.youcode.cch.result.DTOs;

import org.youcode.cch.cyclist.DTOs.EmbeddedCyclistDTO;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.stage.DTOs.EmbeddedStageDTO;

import java.time.Duration;

public class ResultResponseDTO {
    private ResultKey id;
    private Duration time;
    private int rank;
    private EmbeddedStageDTO stageDTO;
    private EmbeddedCyclistDTO cyclistDTO;

    public ResultResponseDTO(){}
    public ResultResponseDTO(ResultKey id, Duration time , int rank , EmbeddedStageDTO stageDTO , EmbeddedCyclistDTO cyclistDTO){
        this.id = id;
        this.time = time;
        this.rank = rank ;
        this.stageDTO = stageDTO;
        this.cyclistDTO = cyclistDTO;
    }

    public int getRank() {
        return rank;
    }

    public Duration getTime() {
        return time;
    }

    public ResultKey getId() {
        return id;
    }

    public EmbeddedCyclistDTO getCyclistDTO() {
        return cyclistDTO;
    }

    public EmbeddedStageDTO getStageDTO() {
        return stageDTO;
    }
}
