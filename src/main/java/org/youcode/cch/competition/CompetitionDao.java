package org.youcode.cch.competition;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.youcode.cch.competition.interfaces.CompetitionDaoI;
import org.youcode.cch.shared.GenericDao;

@Repository
public class CompetitionDao extends GenericDao<Competition> implements CompetitionDaoI{
    public CompetitionDao(SessionFactory sessionFactory){
        super(Competition.class , sessionFactory);
    }
}
