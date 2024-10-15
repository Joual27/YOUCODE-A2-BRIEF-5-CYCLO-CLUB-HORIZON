package org.youcode.cyclist;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.youcode.generalResult.GeneralResult;
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
    private String Nationality;

    @Column(name = "AGE")
    private int age;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "cyclist")
    private List<GeneralResult> generalResults;

}
