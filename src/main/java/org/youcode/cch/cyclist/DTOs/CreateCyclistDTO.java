package org.youcode.cch.cyclist.DTOs;

public class CreateCyclistDTO {
    private String firstName;
    private String lastName;
    private String nationality;
    private int age ;
    private Long teamId;

    public CreateCyclistDTO(String firstName, String lastName , String nationality , int age , Long teamId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
        this.teamId = teamId;
    }

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
