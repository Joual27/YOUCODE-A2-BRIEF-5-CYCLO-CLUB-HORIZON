package org.youcode.cch.cyclist.interfaces;

import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.DTOs.CyclistResponseDTO;

import java.util.List;

public interface CyclistServiceI {

    List<CyclistResponseDTO> getAllCyclists();
    Cyclist getCyclistById(Long id);
    Cyclist save(Cyclist c);
    Cyclist update(Cyclist c);
    Cyclist deleteById(Long id);
    List<Cyclist> getOrderedCyclistListByName();
    List<Cyclist> getOrderedCyclistListByNationality();
    List<Cyclist> getOrderedCyclistListByTeam();

}
