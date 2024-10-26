package org.youcode.cch.generalResult.DTOs;

import java.time.Duration;

public class CreateGeneralResultDTO {
    private Long cyclistId;
    private Long competitionId;
    private Duration overallTime;

    public CreateGeneralResultDTO(){}
    public CreateGeneralResultDTO(Long cyclistId, Long competitionId , Duration overallTime){
        this.competitionId = competitionId;
        this.cyclistId = cyclistId;
        this.overallTime = overallTime;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public Duration getOverallTime() {
        return overallTime;
    }

    public Long getCyclistId() {
        return cyclistId;
    }
}
