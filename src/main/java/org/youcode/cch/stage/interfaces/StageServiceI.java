package org.youcode.cch.stage.interfaces;

import org.youcode.cch.stage.DTOs.CreateAndUpdateStageDTO;
import org.youcode.cch.stage.DTOs.StageResponseDTO;
import org.youcode.cch.stage.Stage;

import java.util.List;

public interface StageServiceI {
    List<Stage> getAllStages();
    Stage getStageById(Long id);
    StageResponseDTO save(CreateAndUpdateStageDTO c);
    Stage update(Stage c);
    Stage deleteById(Long id);
}
