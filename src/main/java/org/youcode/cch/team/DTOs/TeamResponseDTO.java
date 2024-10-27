package org.youcode.cch.team.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.youcode.cch.cyclist.DTOs.EmbeddedCyclistDTO;

import java.util.List;

public class TeamResponseDTO {

    private Long id;
    private String name;
    private List<EmbeddedCyclistDTO> members;

    public TeamResponseDTO(Long id , String name ,List<EmbeddedCyclistDTO> members ){
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<EmbeddedCyclistDTO> getMembers() {
        return members;
    }

    public Long getId() {
        return id;
    }
}
