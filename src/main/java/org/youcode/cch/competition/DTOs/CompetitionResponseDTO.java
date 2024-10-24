package org.youcode.cch.competition.DTOs;

import java.time.LocalDate;

public class CompetitionResponseDTO {
    private Long id;
    private String name;
    private int year;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfStages;

    public CompetitionResponseDTO(Long id , String name , int year , LocalDate startDate , LocalDate endDate , int numberOfStages){
        this.id = id;
        this.name = name;
        this.year = year;
        this.startDate = startDate ;
        this.endDate = endDate ;
        this.numberOfStages = numberOfStages;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getNumberOfStages() {
        return numberOfStages;
    }
}