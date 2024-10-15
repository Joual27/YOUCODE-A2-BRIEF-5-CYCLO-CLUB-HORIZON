package org.youcode.generalResult;

import jakarta.persistence.*;
import org.youcode.competition.Competition;
import org.youcode.cyclist.Cyclist;
import org.youcode.generalResult.embeddables.GeneralResultKey;
import org.youcode.shared.BaseEntity;

import java.time.Duration;


@Entity
public class GeneralResult{

    @EmbeddedId
    private GeneralResultKey id;

    @Column(name = "OVERALL_TIME")
    private Duration overallTime;

    @Column(name = "OVERALL_RANK")
    private int overallRank;

    @ManyToOne()
    @JoinColumn(name = "CYCLIST_ID")
    @MapsId("cyclistId")
    private Cyclist cyclist;

    @ManyToOne()
    @JoinColumn(name = "COMPETITION_ID")
    @MapsId("competitionId")
    private Competition competition;

    public GeneralResult(){}

    public GeneralResultKey getId() {
        return id;
    }

    public void setId(GeneralResultKey id) {
        this.id = id;
    }

    public Duration getOverallTime() {
        return overallTime;
    }

    public void setOverallTime(Duration overallTime) {
        this.overallTime = overallTime;
    }

    public int getOverallRank() {
        return overallRank;
    }

    public void setOverallRank(int overallRank) {
        this.overallRank = overallRank;
    }

    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

}
