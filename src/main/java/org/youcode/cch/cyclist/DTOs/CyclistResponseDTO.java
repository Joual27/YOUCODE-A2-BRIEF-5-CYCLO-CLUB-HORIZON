package org.youcode.cch.cyclist.DTOs;

import org.youcode.cch.team.DTOs.EmbeddedTeamDTO;

public class CyclistResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
    private int age;
    private EmbeddedTeamDTO team;

    public CyclistResponseDTO(Long id, String firstName , String lastName , String nationality , int age , EmbeddedTeamDTO team){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
        this.team = team;
    }
    public Long getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getNationality(){
        return nationality;
    }
    public int getAge(){
        return age;
    }
    public EmbeddedTeamDTO getTeam(){
        return team;
    }
}
