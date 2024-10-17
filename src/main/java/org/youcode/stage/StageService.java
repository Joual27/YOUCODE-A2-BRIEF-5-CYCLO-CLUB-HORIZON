package org.youcode.stage;

import org.youcode.stage.interfaces.StageDaoI;
import org.youcode.stage.interfaces.StageServiceI;

public class StageService implements StageServiceI {
    private final StageDaoI stageDao;

    public StageService(StageDaoI stageDao){
        this.stageDao = stageDao;
    }
}
