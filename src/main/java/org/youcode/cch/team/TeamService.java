package org.youcode.cch.team;

import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.team.interfaces.TeamDaoI;
import org.youcode.cch.team.interfaces.TeamServiceI;

import java.util.Optional;

public class TeamService implements TeamServiceI {

    private final TeamDaoI teamDao;

    public TeamService(TeamDaoI teamDao){
        this.teamDao = teamDao;
    }

    public Team getTeamById(Long id){
        Optional<Team> team = teamDao.findById(id);
        if (team.isEmpty()){
            throw new EntityNotFoundException("No Team found with given ID");
        }
        return team.get();
    }

}
