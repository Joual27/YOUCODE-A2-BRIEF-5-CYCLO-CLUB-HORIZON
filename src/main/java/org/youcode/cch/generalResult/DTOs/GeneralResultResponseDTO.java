package org.youcode.cch.generalResult.DTOs;

import org.youcode.cch.competition.DTOs.EmbeddedCompetitionDTO;
import org.youcode.cch.cyclist.DTOs.EmbeddedCyclistDTO;
import org.youcode.cch.generalResult.embeddables.GeneralResultKey;

import java.time.Duration;

public class GeneralResultResponseDTO {
    private GeneralResultKey id;
    private Duration overallTime;
    private int overallRank;
    private EmbeddedCyclistDTO cyclist;
    private EmbeddedCompetitionDTO competition;

    public GeneralResultResponseDTO(GeneralResultKey id , Duration overallTime , int overallRank , EmbeddedCyclistDTO cyclist , EmbeddedCompetitionDTO competition){
        this.id = id;
        this.competition = competition;
        this.cyclist = cyclist;
        this.overallRank = overallRank;
        this.overallTime = overallTime;
    }

    public Duration getOverallTime() {
        return overallTime;
    }

    public EmbeddedCompetitionDTO getCompetition() {
        return competition;
    }

    public EmbeddedCyclistDTO getCyclist() {
        return cyclist;
    }

    public GeneralResultKey getId() {
        return id;
    }

    public int getOverallRank() {
        return overallRank;
    }
}
