package org.youcode.cch.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.youcode.cch.competition.CompetitionService;
import org.youcode.cch.competition.interfaces.CompetitionDaoI;
import org.youcode.cch.competition.interfaces.CompetitionServiceI;
import org.youcode.cch.cyclist.CyclistService;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.cyclist.interfaces.CyclistServiceI;

import org.youcode.cch.cyclist.mappers.CreateCyclistDTOToCyclistEntityMapper;
import org.youcode.cch.cyclist.mappers.CyclistEntityToCyclistResponseDTOMapper;
import org.youcode.cch.result.ResultService;
import org.youcode.cch.result.interfaces.ResultDaoI;
import org.youcode.cch.result.interfaces.ResultServiceI;
import org.youcode.cch.stage.StageService;
import org.youcode.cch.stage.interfaces.StageDaoI;
import org.youcode.cch.stage.interfaces.StageServiceI;
import org.youcode.cch.team.TeamService;
import org.youcode.cch.team.interfaces.TeamDaoI;
import org.youcode.cch.team.interfaces.TeamServiceI;

@Configuration
public class ServiceConfig {

    @Bean
    public CompetitionServiceI competitionService(CompetitionDaoI competitionDao){
        return new CompetitionService(competitionDao);
    }

    @Bean
    public CyclistServiceI cyclistService(CyclistDaoI cyclistDao , CyclistEntityToCyclistResponseDTOMapper cyclistEntityToCyclistResponseDTOMapper , CreateCyclistDTOToCyclistEntityMapper createCyclistDTOToCyclistEntityMapper){
        return new CyclistService(cyclistDao , cyclistEntityToCyclistResponseDTOMapper,createCyclistDTOToCyclistEntityMapper);
    }

//    @Bean
//    public GeneralResultServiceI generalResultService(GeneralResultDaoI generalResultDao){
//        return new GeneralResultService(generalResultDao);
//    }

    @Bean
    public ResultServiceI resultService(ResultDaoI resultDao){
        return new ResultService(resultDao);
    }

    @Bean
    public StageServiceI stageService(StageDaoI stageDao){
        return new StageService(stageDao);
    }

    @Bean
    public TeamServiceI teamService(TeamDaoI teamDao){
        return new TeamService(teamDao);
    }

}
