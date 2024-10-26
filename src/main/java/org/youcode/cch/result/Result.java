package org.youcode.cch.result;

import jakarta.persistence.*;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.stage.Stage;

import java.time.Duration;

@Entity
public class    Result {
    @EmbeddedId
    private ResultKey id;
    private Duration time;
    private int rank;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("stageId")
    @JoinColumn(name = "STAGE_ID")
    private Stage stage;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("cyclistId")
    @JoinColumn(name = "CYCLIST_ID")
    private Cyclist cyclist;

    public Result(){};

    public ResultKey getId() {
        return id;
    }

    public void setId(ResultKey id) {
        this.id = id;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }
}
