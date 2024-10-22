package org.youcode.cch.team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.shared.BaseEntity;

import java.util.List;

@Entity
public class Team extends BaseEntity {

    @Column(name = "NAME")
    private String name ;

    @OneToMany(mappedBy = "")
    private List<Cyclist> members;

    public Team(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cyclist> getMembers() {
        return members;
    }

    public void setMembers(List<Cyclist> members) {
        this.members = members;
    }
}
