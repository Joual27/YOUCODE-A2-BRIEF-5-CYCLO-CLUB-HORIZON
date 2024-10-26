package org.youcode.cch.result.DTOs;

import org.youcode.cch.cyclist.DTOs.EmbeddedCyclistDTO;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.stage.DTOs.EmbeddedStageDTO;

import java.time.Duration;

public class ResultResponseDTO {
    private ResultKey id;
    private Duration time;
    private int rank;
    private EmbeddedStageDTO stage;
    private EmbeddedCyclistDTO cyclist;

    public ResultResponseDTO(ResultKey id, Duration time , int rank , EmbeddedStageDTO stage , EmbeddedCyclistDTO cyclist){
        this.id = id;
        this.time = time;
        this.rank = rank ;
        this.stage = stage;
        this.cyclist = cyclist;
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

    public EmbeddedCyclistDTO getCyclist() {
        return cyclist;
    }

    public EmbeddedStageDTO getStage() {
        return stage;
    }
}
