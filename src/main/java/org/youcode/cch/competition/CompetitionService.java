package org.youcode.cch.competition;

import org.youcode.cch.competition.interfaces.CompetitionDaoI;
import org.youcode.cch.competition.interfaces.CompetitionServiceI;

import java.util.List;
import java.util.Optional;

public class CompetitionService implements CompetitionServiceI {
    private final CompetitionDaoI competitionDao;

    public CompetitionService(CompetitionDaoI competitionDao){
        this.competitionDao = competitionDao;
    }

    public List<Competition> getAllCompetitions(){
        return competitionDao.findAll();
    }

    public Competition getCompetitionEntityById(Long id){
        Optional<Competition> competition = competitionDao.findById(id);
        return competition.orElse(null);
    }
    public Competition save(Competition c){
        competitionDao.save(c);
        return c;
    }
    public Competition update(Competition c){
        competitionDao.update(c);
        return c;
    }
    public Competition deleteById(Long id){
        Competition c = getCompetitionEntityById(id);
        if (c != null){
            competitionDao.deleteById(id);
        }
        return c;
    }
}
