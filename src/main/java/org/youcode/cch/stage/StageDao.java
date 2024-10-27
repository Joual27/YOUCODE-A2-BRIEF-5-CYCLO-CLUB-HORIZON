package org.youcode.cch.stage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    public void setStageAsCompleted(Stage stage){
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            Stage s = session.get(Stage.class, stage.getId());
            s.setIsCompleted(true);
            session.merge(s);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction rolled back due to: " + e.getMessage());
            }
        }
    }
}
