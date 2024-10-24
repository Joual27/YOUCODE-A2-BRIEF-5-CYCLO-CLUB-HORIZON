package org.youcode.cch.cyclist;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.youcode.cch.generalResult.GeneralResult;
import org.youcode.cch.result.Result;
import org.youcode.cch.shared.BaseEntity;
import org.youcode.cch.team.Team;

import java.util.List;

@Entity
public class Cyclist extends BaseEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NATIONALITY")
    private String nationality;

    @Column(name = "AGE")
    private int age;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "cyclist" , fetch = FetchType.EAGER)
    private List<GeneralResult> generalResults;

    @OneToMany(mappedBy = "cyclist" , fetch = FetchType.EAGER)
    private List<Result> results;

    public Cyclist(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<GeneralResult> getGeneralResults() {
        return generalResults;
    }

    public void setGeneralResults(List<GeneralResult> generalResults) {
        this.generalResults = generalResults;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
