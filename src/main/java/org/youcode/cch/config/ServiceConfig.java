package org.youcode.cch.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.youcode.cch.competition.CompetitionService;
import org.youcode.cch.competition.interfaces.CompetitionDaoI;
import org.youcode.cch.competition.interfaces.CompetitionServiceI;
import org.youcode.cch.competition.mappers.CompetitionEntityToCompetitionResponseDTOMapper;
import org.youcode.cch.competition.mappers.CreateAndUpdateCompetitionDTOToCompetitionEntityMapper;
import org.youcode.cch.cyclist.CyclistService;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.cyclist.interfaces.CyclistServiceI;

import org.youcode.cch.cyclist.mappers.CreateCyclistDTOToCyclistEntityMapper;
import org.youcode.cch.cyclist.mappers.CyclistEntityToCyclistResponseDTOMapper;
//import org.youcode.cch.result.ResultService;
import org.youcode.cch.generalResult.GeneralResultService;
import org.youcode.cch.generalResult.interfaces.GeneralResultDaoI;
import org.youcode.cch.generalResult.interfaces.GeneralResultServiceI;
import org.youcode.cch.generalResult.mappers.CreateGeneralResultDTOToGeneralResultEntityMapper;
import org.youcode.cch.generalResult.mappers.GeneralResultEntityToGeneralResultResponseDTOMapper;
import org.youcode.cch.result.ResultService;
import org.youcode.cch.result.interfaces.ResultDaoI;
import org.youcode.cch.result.interfaces.ResultServiceI;
import org.youcode.cch.result.mappers.CreateResultDTOToResultEntityMapper;
import org.youcode.cch.result.mappers.ResultEntityToResultResponseDTOMapper;
import org.youcode.cch.stage.StageService;
import org.youcode.cch.stage.interfaces.StageDaoI;
import org.youcode.cch.stage.interfaces.StageServiceI;
import org.youcode.cch.stage.mappers.CreateAndUpdateStageDTOToEntityMapper;
import org.youcode.cch.stage.mappers.StageEntityToStageResponseDTOMapper;
import org.youcode.cch.team.TeamService;
import org.youcode.cch.team.interfaces.TeamDaoI;
import org.youcode.cch.team.interfaces.TeamServiceI;

@Configuration
public class ServiceConfig {

    @Bean
    public CompetitionServiceI competitionService(CompetitionDaoI competitionDao , StageDaoI stageDao , CreateAndUpdateCompetitionDTOToCompetitionEntityMapper createAndUpdateCompetitionDTOToCompetitionEntityMapper , CompetitionEntityToCompetitionResponseDTOMapper competitionEntityToCompetitionResponseDTOMapper){
        return new CompetitionService(competitionDao , stageDao ,createAndUpdateCompetitionDTOToCompetitionEntityMapper , competitionEntityToCompetitionResponseDTOMapper );
    }

    @Bean
    public CyclistServiceI cyclistService(CyclistDaoI cyclistDao , CyclistEntityToCyclistResponseDTOMapper cyclistEntityToCyclistResponseDTOMapper , CreateCyclistDTOToCyclistEntityMapper createCyclistDTOToCyclistEntityMapper){
        return new CyclistService(cyclistDao , cyclistEntityToCyclistResponseDTOMapper,createCyclistDTOToCyclistEntityMapper);
    }

    @Bean
    public GeneralResultServiceI generalResultService(GeneralResultDaoI generalResultDao , CompetitionDaoI competitionDao , CyclistDaoI cyclistDao , CreateGeneralResultDTOToGeneralResultEntityMapper createGeneralResultDTOToGeneralResultEntityMapper , GeneralResultEntityToGeneralResultResponseDTOMapper generalResultEntityToGeneralResultResponseDTOMapper){
        return new GeneralResultService(generalResultDao,competitionDao , cyclistDao ,createGeneralResultDTOToGeneralResultEntityMapper , generalResultEntityToGeneralResultResponseDTOMapper);
    }

    @Bean
    public ResultServiceI resultService(ResultDaoI resultDao , CreateResultDTOToResultEntityMapper createResultDTOToResultEntityMapper , StageDaoI stageDao , CyclistDaoI cyclistDao , ResultEntityToResultResponseDTOMapper resultEntityToResultResponseDTOMapper){
        return new ResultService(resultDao,createResultDTOToResultEntityMapper,stageDao , cyclistDao , resultEntityToResultResponseDTOMapper);
    }

    @Bean
    public StageServiceI stageService(StageDaoI stageDao , CreateAndUpdateStageDTOToEntityMapper createAndUpdateStageDTOToEntityMapper , StageEntityToStageResponseDTOMapper stageEntityToStageResponseDTOMapper){
        return new StageService(stageDao , createAndUpdateStageDTOToEntityMapper , stageEntityToStageResponseDTOMapper);
    }

    @Bean
    public TeamServiceI teamService(TeamDaoI teamDao){
        return new TeamService(teamDao);
    }

}
