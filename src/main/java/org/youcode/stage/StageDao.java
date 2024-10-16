package org.youcode.stage;

import org.youcode.shared.GenericDao;
import org.youcode.stage.interfaces.StageDaoI;

public class StageDao extends GenericDao<Stage> implements StageDaoI {
   public StageDao(){
       super(Stage.class);
   }
}
