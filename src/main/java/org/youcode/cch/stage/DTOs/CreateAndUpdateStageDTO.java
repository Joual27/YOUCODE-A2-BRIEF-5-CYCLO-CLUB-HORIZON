package org.youcode.cch.stage.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAndUpdateStageDTO {
    @NotNull(message = "Number Field is mandatory")
    private Integer number;

    @NotBlank(message = "Start location Field is mandatory")
    @Size(min = 2, max = 50)
    private String startLocation;

    @NotBlank(message = "End location Field is mandatory")
    @Size(min = 2, max = 50)
    private String endLocation;

    @NotBlank(message = "Type Field is  mandatory")
    private String type;

    @NotNull
    private Long competitionId;

    public CreateAndUpdateStageDTO(){}

    public CreateAndUpdateStageDTO(int number , String startLocation , String endLocation , String type , Long competitionId){
        this.number = number;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.type = type;
        this.competitionId = competitionId;
    }

    public int getNumber() {
        return number;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getType() {
        return type;
    }

    public Long getCompetitionId() {
        return competitionId;
    }
}
