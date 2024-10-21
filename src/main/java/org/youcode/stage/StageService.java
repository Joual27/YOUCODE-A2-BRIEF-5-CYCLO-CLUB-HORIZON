package org.youcode.stage;

import org.youcode.stage.interfaces.StageDaoI;
import org.youcode.stage.interfaces.StageServiceI;

import java.util.List;
import java.util.Optional;

public class StageService implements StageServiceI {
    private final StageDaoI stageDao;

    public StageService(StageDaoI stageDao){
        this.stageDao = stageDao;
    }

    public List<Stage> getAllStages(){
        return stageDao.findAll();
    }
    public Stage getStageById(Long id){
        Optional<Stage> s = stageDao.findById(id);
        return s.orElse(null);
    }
    public Stage save(Stage c){
        stageDao.save(c);
        return c;
    }
    public Stage update(Stage c){
        stageDao.update(c);
        return c;
    }
    public Stage deleteById(Long id){
        Stage s = getStageById(id);
        if (s != null){
            stageDao.deleteById(id);
        }
        return s;
    }
}
