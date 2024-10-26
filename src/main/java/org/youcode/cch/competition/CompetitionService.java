package org.youcode.cch.competition;

import org.youcode.cch.competition.DTOs.CompetitionResponseDTO;
import org.youcode.cch.competition.DTOs.CreateAndUpdateCompetitionDTO;
import org.youcode.cch.competition.interfaces.CompetitionDaoI;
import org.youcode.cch.competition.interfaces.CompetitionServiceI;
import org.youcode.cch.exceptions.EntityNotFoundException;

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
        if (competition.isEmpty()){
            throw new EntityNotFoundException("No competition found with the given ID !");
        }
        return competition.get();
    }
    public CompetitionResponseDTO save(CreateAndUpdateCompetitionDTO c){
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
