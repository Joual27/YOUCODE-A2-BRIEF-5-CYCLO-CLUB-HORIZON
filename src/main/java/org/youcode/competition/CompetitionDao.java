package org.youcode.competition;

import org.youcode.competition.interfaces.CompetitionDaoI;
import org.youcode.shared.GenericDao;

public class CompetitionDao extends GenericDao<Competition> implements CompetitionDaoI{
    public CompetitionDao(){
        super(Competition.class);
    }
}
