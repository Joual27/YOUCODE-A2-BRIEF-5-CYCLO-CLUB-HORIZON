package org.youcode.competition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.youcode.generalResult.GeneralResult;
import org.youcode.shared.BaseEntity;
import org.youcode.stage.Stage;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Competition extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "NUMBER_OF_STAGES")
    private int numberOfStages;

    @OneToMany(mappedBy = "competition" , fetch = FetchType.EAGER)
    private List<GeneralResult> generalResults;

    @OneToMany(mappedBy = "competition", fetch = FetchType.EAGER)
    private List<Stage> stages ;

    public Competition(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<GeneralResult> getGeneralResults() {
        return generalResults;
    }

    public void setGeneralResults(List<GeneralResult> generalResults) {
        this.generalResults = generalResults;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public int getNumberOfStages(){
        return numberOfStages;
    }

    public void setNumberOfStages(int numberOfStages){
        this.numberOfStages = numberOfStages;
    }
}
