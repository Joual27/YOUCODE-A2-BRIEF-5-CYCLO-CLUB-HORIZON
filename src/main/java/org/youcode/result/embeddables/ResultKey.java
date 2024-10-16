package org.youcode.result.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResultKey implements Serializable {
    @Column(name = "STAGE_ID")
    private Long stageId;

    @Column(name = "CYCLIST_ID")
    private Long cyclistId;

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public Long getCyclistId() {
        return cyclistId;
    }

    public void setCyclistId(Long cyclistId) {
        this.cyclistId = cyclistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultKey that = (ResultKey) o;
        return Objects.equals(stageId, that.stageId) &&
                Objects.equals(cyclistId, that.cyclistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stageId, cyclistId);
    }
}
