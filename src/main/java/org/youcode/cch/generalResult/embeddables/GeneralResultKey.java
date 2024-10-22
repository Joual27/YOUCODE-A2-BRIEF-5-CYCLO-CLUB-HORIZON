package org.youcode.cch.generalResult.embeddables;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GeneralResultKey implements Serializable {

    @Column(name="CYCLIST_ID")
    private Long cyclistId;

    @Column(name="COMPETITION_ID")
    private Long competitionId;

    public GeneralResultKey(){}

    public Long getCyclistId() {
        return cyclistId;
    }

    public void setCyclistId(Long cyclistId) {
        this.cyclistId = cyclistId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResultKey that = (GeneralResultKey) o;
        return Objects.equals(cyclistId, that.cyclistId) &&
                Objects.equals(competitionId, that.competitionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cyclistId, competitionId);
    }


}