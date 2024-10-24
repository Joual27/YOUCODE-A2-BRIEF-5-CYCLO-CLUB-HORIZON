package org.youcode.cch.stage.DTOs;

import org.youcode.cch.competition.DTOs.EmbeddedCompetitionDTO;

public class StageResponseDTO {
    private Long id;
    private int number ;
    private String startLocation;
    private String endLocation;
    private String type;
    private EmbeddedCompetitionDTO competition;


    public StageResponseDTO(Long id , int number , String startLocation , String endLocation , String type , Long competitionId , EmbeddedCompetitionDTO competition){
        this.id = id;
        this.number = number;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.type = type;
        this.competition = competition;
    }

    public Long getId(){
        return id;
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

    public EmbeddedCompetitionDTO getCompetition(){
        return competition;
    }
}
