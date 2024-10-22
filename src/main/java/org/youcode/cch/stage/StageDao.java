package org.youcode.cch.stage;

import org.hibernate.SessionFactory;
import org.youcode.cch.shared.GenericDao;
import org.youcode.cch.stage.interfaces.StageDaoI;

public class StageDao extends GenericDao<Stage> implements StageDaoI {
   public StageDao(SessionFactory sessionFactory){
       super(Stage.class , sessionFactory);
   }
}
