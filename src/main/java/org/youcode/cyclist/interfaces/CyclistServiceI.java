package org.youcode.cyclist.interfaces;

import org.youcode.cyclist.Cyclist;

import java.util.List;

public interface CyclistServiceI {

    List<Cyclist> getAllCyclists();
    Cyclist getCyclistById(Long id);
    Cyclist save(Cyclist c);
    Cyclist update(Cyclist c);
    Cyclist deleteById(Long id);
    List<Cyclist> getOrderedCyclistListByName();
    List<Cyclist> getOrderedCyclistListByNationality();
    List<Cyclist> getOrderedCyclistListByTeam();

}
