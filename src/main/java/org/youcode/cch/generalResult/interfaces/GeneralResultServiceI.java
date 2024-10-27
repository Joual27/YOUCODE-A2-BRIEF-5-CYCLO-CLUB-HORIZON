package org.youcode.cch.generalResult.interfaces;

import org.youcode.cch.generalResult.DTOs.CreateGeneralResultDTO;
import org.youcode.cch.generalResult.DTOs.GeneralResultResponseDTO;

import java.util.List;

public interface GeneralResultServiceI {
    GeneralResultResponseDTO save(CreateGeneralResultDTO generalResultDTO);
    GeneralResultResponseDTO getGeneralResultOfCyclistInCompetition(Long competitionId , Long cyclistId);
    List<GeneralResultResponseDTO> getAllGeneralResults();
    GeneralResultResponseDTO delete(Long competitionId , Long cyclistId);
}
