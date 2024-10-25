package org.youcode.cch.result;

import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.DTOs.ResultResponseDTO;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.result.interfaces.ResultDaoI;
import org.youcode.cch.result.interfaces.ResultServiceI;
import org.youcode.cch.result.mappers.CreateResultDTOToResultEntityMapper;
import org.youcode.cch.stage.mappers.CreateAndUpdateStageDTOToEntityMapper;

import java.util.Comparator;
import java.util.List;

public class ResultService implements ResultServiceI {
    private final ResultDaoI resultDao;
    private final CreateResultDTOToResultEntityMapper createResultDTOToResultEntityMapper;

    public ResultService(ResultDaoI resultDao , CreateResultDTOToResultEntityMapper createResultDTOToResultEntityMapper ){
        this.resultDao = resultDao;
        this.createResultDTOToResultEntityMapper = createResultDTOToResultEntityMapper;
    }

    public ResultKey generateResultKey(Long stageId, Long cyclistId){
        return new ResultKey(stageId,cyclistId);
    }

    public int assignRankToResult(Result resultOnCreation){
        List<Result> results = resultDao.findResultsByStage(resultOnCreation.getStage());
        results.add(resultOnCreation);
        results.sort(Comparator.comparing(Result::getTime));
        int rank = 1;
        for (Result r : results){
            if (r.equals(resultOnCreation)){
                break;
            }
            rank ++ ;
        }
        return rank;
    }

    public ResultResponseDTO save(CreateResultDTO result){

    }

    public ResultResponseDTO update(CreateResultDTO result){
         Result resultToCreate = createResultDTOToResultEntityMapper.toEntity(result);
    }

}
