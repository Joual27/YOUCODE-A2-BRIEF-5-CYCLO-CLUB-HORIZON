package org.youcode.cch.stage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.youcode.cch.competition.Competition;
import org.youcode.cch.result.Result;
import org.youcode.cch.shared.BaseEntity;

import java.util.List;

@Entity
public class Stage extends BaseEntity {

    @NotNull
    @Column(name = "NUMBER")
    private int number;


    @NotNull
    @Size(min = 2 , max = 50)
    @Column(name = "START_LOCATION")
    private String startLocation;


    @NotNull
    @Size(min = 2 , max = 50)
    @Column(name = "END_LOCATION")
    private String endLocation;


    @NotNull
    @Column(name = "TYPE")
    private String type;

    @ManyToOne
    private Competition competition ;

    @OneToMany(mappedBy = "stage")
    private List<Result> results;

    public Stage(){};

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
