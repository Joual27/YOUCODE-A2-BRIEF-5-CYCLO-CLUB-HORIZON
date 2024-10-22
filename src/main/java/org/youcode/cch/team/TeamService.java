package org.youcode.cch.team;

import org.youcode.cch.team.interfaces.TeamDaoI;
import org.youcode.cch.team.interfaces.TeamServiceI;

public class TeamService implements TeamServiceI {

    private final TeamDaoI teamDao;

    public TeamService(TeamDaoI teamDao){
        this.teamDao = teamDao;
    }

    public Team getTeamById(Long id){
        return teamDao.findById(id).orElse(null);
    }

}
