package org.youcode.stage.interfaces;

import org.youcode.stage.Stage;

import java.util.List;

public interface StageServiceI {
    List<Stage> getAllStages();
    Stage getStageById(Long id);
    Stage save(Stage c);
    Stage update(Stage c);
    Stage deleteById(Long id);
}
