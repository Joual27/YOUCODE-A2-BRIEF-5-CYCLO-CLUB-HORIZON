package org.youcode.cch.team;

import org.hibernate.SessionFactory;
import org.youcode.cch.shared.GenericDao;
import org.youcode.cch.team.interfaces.TeamDaoI;

public class TeamDao extends GenericDao<Team> implements TeamDaoI {
    public TeamDao(SessionFactory sessionFactory){
        super(Team.class,sessionFactory);
    }
}
