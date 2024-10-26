package org.youcode.cch.competition.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateAndUpdateCompetitionDTO {

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Min(2000)
    @Max(2030)
    private int year;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @Min(3)
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
