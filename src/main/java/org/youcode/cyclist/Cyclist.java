package org.youcode.cyclist;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.youcode.generalResult.GeneralResult;
import org.youcode.result.Result;
import org.youcode.shared.BaseEntity;
import org.youcode.team.Team;

import java.util.List;

@Entity
public class Cyclist extends BaseEntity {

    @Column(name = "FIRST_NAME")
    private String firstName ;

    @Column(name = "LAST_NAME")
    private String lastName ;

    @Column(name = "NATIONALITY")
    private String nationality;

    @Column(name = "AGE")
    private int age;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "cyclist")
    private List<GeneralResult> generalResults;

    @OneToMany(mappedBy = "cyclist")
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
