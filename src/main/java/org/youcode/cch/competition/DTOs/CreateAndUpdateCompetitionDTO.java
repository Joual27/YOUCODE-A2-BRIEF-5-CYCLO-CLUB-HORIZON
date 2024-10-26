package org.youcode.cch.competition.DTOs;

import org.youcode.cch.stage.DTOs.EmbeddedStageDTO;

import java.time.LocalDate;
import java.util.List;

public class CreateAndUpdateCompetitionDTO {
    private String name;
    private int year;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfStages;

    public CreateAndUpdateCompetitionDTO(){}
    public CreateAndUpdateCompetitionDTO(String name , int year , LocalDate startDate , LocalDate endDate , int numberOfStages){
        this.name = name;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfStages = numberOfStages;
    }

    public int getNumberOfStages() {
        return numberOfStages;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

}
