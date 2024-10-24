package org.youcode.cch.cyclist.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAndUpdateCyclistDTO {


    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 50)
    private String nationality;

    @NotNull()
    @Min(15)
    private int age ;

    @NotNull
    private Long teamId;

    public CreateAndUpdateCyclistDTO(String firstName, String lastName , String nationality , int age , Long teamId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
        this.teamId = teamId;
    }

    public CreateAndUpdateCyclistDTO(){}


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality(){
        return nationality;
    }

    public Long getTeamId(){
        return teamId;
    }
}
