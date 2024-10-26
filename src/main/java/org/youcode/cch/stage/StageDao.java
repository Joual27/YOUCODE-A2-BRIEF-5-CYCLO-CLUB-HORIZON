package org.youcode.cch.stage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.youcode.cch.competition.Competition;
import org.youcode.cch.shared.GenericDao;
import org.youcode.cch.stage.interfaces.StageDaoI;

import java.util.List;

public class StageDao extends GenericDao<Stage , Long> implements StageDaoI {
   public StageDao(SessionFactory sessionFactory){
       super(Stage.class , sessionFactory);
   }

    public List<Stage> getStagesOfCompetition (Competition competition){
       try(Session session = openSession()){
           String query = "FROM Stage s WHERE s.competition = :competition";
           return session.createQuery(query , Stage.class)
                   .setParameter("competition" , competition)
                   .getResultList();
       }
    }
}
