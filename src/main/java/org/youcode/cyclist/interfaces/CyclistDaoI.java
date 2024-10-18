package org.youcode.cyclist.interfaces;

import org.youcode.cyclist.Cyclist;
import org.youcode.shared.interfaces.GenericDaoI;

import java.util.List;

public interface CyclistDaoI extends GenericDaoI<Cyclist>{
    List<Cyclist> sortCyclistByName();
    List<Cyclist> sortCyclistByNationality();
    List<Cyclist> sortCyclistByTeam();
}
