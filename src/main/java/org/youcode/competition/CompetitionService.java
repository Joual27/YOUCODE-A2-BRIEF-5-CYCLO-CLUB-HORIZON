package org.youcode.competition;

import org.youcode.competition.interfaces.CompetitionDaoI;
import org.youcode.competition.interfaces.CompetitionServiceI;

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
    public Competition getCompetitionById(Long id){
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
        Competition c = getCompetitionById(id);
        if (c != null){
            competitionDao.deleteById(id);
        }
        return c;
    }
}
