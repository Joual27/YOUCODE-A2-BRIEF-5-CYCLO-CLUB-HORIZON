package org.youcode.team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.youcode.cyclist.Cyclist;
import org.youcode.shared.BaseEntity;

import java.util.List;

@Entity
public class Team extends BaseEntity {

    @Column(name = "NAME")
    private String name ;

    @OneToMany(mappedBy = "")
    private List<Cyclist> members;
}
