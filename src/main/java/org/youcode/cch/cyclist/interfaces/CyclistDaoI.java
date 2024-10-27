package org.youcode.cch.cyclist.interfaces;

import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.shared.interfaces.GenericDaoI;
import org.youcode.cch.team.Team;

import java.util.List;

public interface CyclistDaoI extends GenericDaoI<Cyclist , Long>{
    List<Cyclist> sortCyclistByName();
    List<Cyclist> sortCyclistByNationality();
    List<Cyclist> sortCyclistByTeam();
    List<Cyclist> getCyclistsOfTeam(Team t);
}
