package org.youcode.cch.cyclist.DTOs;

public class EmbeddedCyclistDTO {
    private String firstName;
    private String lastName;
    private String nationality;


    public EmbeddedCyclistDTO(String firstName , String lastName ,String nationality){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getNationality() {
        return nationality;
    }
}
