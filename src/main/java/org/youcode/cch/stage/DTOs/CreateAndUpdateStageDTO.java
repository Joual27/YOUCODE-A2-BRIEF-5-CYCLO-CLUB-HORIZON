package org.youcode.cch.stage.DTOs;

public class CreateAndUpdateStageDTO {
    private int number ;
    private String startLocation;
    private String endLocation;
    private String type;
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
