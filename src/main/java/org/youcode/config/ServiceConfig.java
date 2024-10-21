package org.youcode.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.youcode.competition.CompetitionService;
import org.youcode.competition.interfaces.CompetitionDaoI;
import org.youcode.competition.interfaces.CompetitionServiceI;
import org.youcode.cyclist.CyclistService;
import org.youcode.cyclist.interfaces.CyclistDaoI;
import org.youcode.cyclist.interfaces.CyclistServiceI;
import org.youcode.generalResult.interfaces.GeneralResultDaoI;

import org.youcode.result.ResultService;
import org.youcode.result.interfaces.ResultDaoI;
import org.youcode.result.interfaces.ResultServiceI;
import org.youcode.stage.StageService;
import org.youcode.stage.interfaces.StageDaoI;
import org.youcode.stage.interfaces.StageServiceI;

@Configuration
public class ServiceConfig {

    @Bean
    public CompetitionServiceI competitionService(CompetitionDaoI competitionDao){
        return new CompetitionService(competitionDao);
    }

    @Bean
    public CyclistServiceI cyclistService(CyclistDaoI cyclistDao){
        return new CyclistService(cyclistDao);
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

}
