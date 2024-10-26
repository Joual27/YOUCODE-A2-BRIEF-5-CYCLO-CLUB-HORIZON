package org.youcode.cch.generalResult;

import org.youcode.cch.competition.Competition;
import org.youcode.cch.competition.interfaces.CompetitionDaoI;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.generalResult.DTOs.CreateGeneralResultDTO;
import org.youcode.cch.generalResult.DTOs.GeneralResultResponseDTO;
import org.youcode.cch.generalResult.interfaces.GeneralResultDaoI;
import org.youcode.cch.generalResult.interfaces.GeneralResultServiceI;
import org.youcode.cch.generalResult.mappers.CreateGeneralResultDTOToGeneralResultEntityMapper;

import java.util.Comparator;
import java.util.List;

public class GeneralResultService implements GeneralResultServiceI {
    private final GeneralResultDaoI generalResultDao;
    private final CompetitionDaoI competitionDao;
    private final CyclistDaoI cyclistDao;
    private final CreateGeneralResultDTOToGeneralResultEntityMapper createGeneralResultDTOToGeneralResultEntityMapper;

    public GeneralResultService(GeneralResultDaoI generalResultDao , CompetitionDaoI competitionDao , CyclistDaoI cyclistDao ,  CreateGeneralResultDTOToGeneralResultEntityMapper createGeneralResultDTOToGeneralResultEntityMapper ){
        this.generalResultDao = generalResultDao;
        this.competitionDao = competitionDao;
        this.cyclistDao = cyclistDao;
        this.createGeneralResultDTOToGeneralResultEntityMapper = createGeneralResultDTOToGeneralResultEntityMapper;
    }

    private int assignOverallRankToCyclist(GeneralResult generalResultToCreate){
        List<GeneralResult> results = generalResultDao.getGeneralResultsOfCompetition(generalResultToCreate.getCompetition());
        results.add(generalResultToCreate);
        results.sort(Comparator.comparing(GeneralResult::getOverallTime));

        int rank = 1;

        for (GeneralResult r : results){
            if (r.equals(generalResultToCreate)){
                break;
            }
            rank ++ ;
        }
        return rank;
    }

    @Override
    public GeneralResultResponseDTO save(CreateGeneralResultDTO generalResultDTO){
        Cyclist c = cyclistDao.findById(generalResultDTO.getCyclistId())
                .orElseThrow(() -> new EntityNotFoundException("No Cyclist with given id was found !"));
        Competition competition = competitionDao.findById(generalResultDTO.getCompetitionId())
                .orElseThrow(() -> new EntityNotFoundException("No Competition with given id was found !"));
        GeneralResult generalResultToCreate = createGeneralResultDTOToGeneralResultEntityMapper.toEntity(generalResultDTO);
        generalResultToCreate.setOverallRank(assignOverallRankToCyclist(generalResultToCreate));
        GeneralResult createdGeneralResult = generalResultDao.save(generalResultToCreate);
        return
    }
}
