package org.youcode.competition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.youcode.generalResult.GeneralResult;
import org.youcode.shared.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Competition extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @OneToMany(mappedBy = "competition")
    private List<GeneralResult> generalResults;

}
