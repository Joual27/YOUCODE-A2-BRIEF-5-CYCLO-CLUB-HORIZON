package org.youcode.cch.stage.interfaces;

import org.youcode.cch.stage.DTOs.CreateAndUpdateStageDTO;
import org.youcode.cch.stage.DTOs.StageResponseDTO;
import org.youcode.cch.stage.Stage;

import java.util.List;

public interface StageServiceI {
    List<StageResponseDTO> getAllStages();
    StageResponseDTO getStageById(Long id);
    StageResponseDTO save(CreateAndUpdateStageDTO c);
    StageResponseDTO update(Long id , CreateAndUpdateStageDTO c);
    StageResponseDTO deleteById(Long id);
    StageResponseDTO markStageAsCompleted(Long id);
}
