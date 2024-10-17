package org.youcode.stage;

import org.hibernate.SessionFactory;
import org.youcode.shared.GenericDao;
import org.youcode.stage.interfaces.StageDaoI;

public class StageDao extends GenericDao<Stage> implements StageDaoI {
   public StageDao(SessionFactory sessionFactory){
       super(Stage.class , sessionFactory);
   }
}
