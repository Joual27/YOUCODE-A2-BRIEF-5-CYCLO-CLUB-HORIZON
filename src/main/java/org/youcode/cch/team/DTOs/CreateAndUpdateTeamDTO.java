package org.youcode.cch.team.DTOs;

import jakarta.validation.constraints.NotNull;

public class CreateAndUpdateTeamDTO {
    @NotNull
    private String name;

    public CreateAndUpdateTeamDTO(String name){
        this.name = name;
    }
    public CreateAndUpdateTeamDTO(){}

    public String getName() {
        return name;
    }
}
