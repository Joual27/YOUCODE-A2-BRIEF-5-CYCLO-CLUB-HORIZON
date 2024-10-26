package org.youcode.cch.generalResult;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.youcode.cch.competition.Competition;
import org.youcode.cch.generalResult.embeddables.GeneralResultKey;
import org.youcode.cch.generalResult.interfaces.GeneralResultDaoI;
import org.youcode.cch.shared.GenericDao;

import java.util.List;


@Repository
public class GeneralResultDao extends GenericDao<GeneralResult , GeneralResultKey> implements GeneralResultDaoI {
    public GeneralResultDao(SessionFactory sessionFactory){
        super(GeneralResult.class ,sessionFactory );
    }


    public List<GeneralResult> getGeneralResultsOfCompetition(Competition c){
        try(Session s = openSession()){
            String query = "FROM GeneralResult g WHERE g.competition = :competition";
            return s.createQuery(query , GeneralResult.class)
                    .setParameter("competition" , c)
                    .getResultList();
        }
    }
}
