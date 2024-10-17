package org.youcode.competition;

import org.youcode.competition.interfaces.CompetitionDaoI;
import org.youcode.competition.interfaces.CompetitionServiceI;

public class CompetitionService implements CompetitionServiceI {
    private final CompetitionDaoI competitionDao;

    public CompetitionService(CompetitionDaoI competitionDao){
        this.competitionDao = competitionDao;
    }
}
