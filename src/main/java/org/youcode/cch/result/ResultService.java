package org.youcode.cch.result;

import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.DTOs.ResultResponseDTO;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.result.interfaces.ResultDaoI;
import org.youcode.cch.result.interfaces.ResultServiceI;
import org.youcode.cch.result.mappers.CreateResultDTOToResultEntityMapper;
import org.youcode.cch.result.mappers.ResultEntityToResultResponseDTOMapper;
import org.youcode.cch.stage.Stage;
import org.youcode.cch.stage.interfaces.StageDaoI;


import java.util.Comparator;
import java.util.List;

public class ResultService implements ResultServiceI {
    private final ResultDaoI resultDao;
    private final StageDaoI stageDao;
    private final CyclistDaoI cyclistDao;
    private final CreateResultDTOToResultEntityMapper createResultDTOToResultEntityMapper;
    private final ResultEntityToResultResponseDTOMapper resultEntityToResultResponseDTOMapper;

    public ResultService(ResultDaoI resultDao , CreateResultDTOToResultEntityMapper createResultDTOToResultEntityMapper , StageDaoI stageDao , CyclistDaoI cyclistDao , ResultEntityToResultResponseDTOMapper resultEntityToResultResponseDTOMapper){
        this.resultDao = resultDao;
        this.createResultDTOToResultEntityMapper = createResultDTOToResultEntityMapper;
        this.stageDao = stageDao;
        this.cyclistDao = cyclistDao;
        this.resultEntityToResultResponseDTOMapper = resultEntityToResultResponseDTOMapper;
    }

    @Override
    public ResultKey generateResultKey(Long stageId, Long cyclistId){
        return new ResultKey(stageId,cyclistId);
    }

    @Override
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

    @Override
    public ResultResponseDTO save(CreateResultDTO result){
        Stage s = stageDao.findById(result.getStageId())
                .orElseThrow(() -> new EntityNotFoundException("No Stage With given id Was Found !"));
        Cyclist c = cyclistDao.findById(result.getCyclistId())
                .orElseThrow(() -> new EntityNotFoundException("No Cyclist With given id Was Found !"));
        Result resultToCreate = createResultDTOToResultEntityMapper.toEntity(result);
        resultToCreate.setRank(assignRankToResult(resultToCreate));
        Result createdRes = resultDao.save(resultToCreate);
        return resultEntityToResultResponseDTOMapper.entityToDto(createdRes);
    }

    @Override
    public ResultResponseDTO getCyclistStageResult(Long stageId , Long cyclistId){
        ResultKey id = generateResultKey(stageId,cyclistId);
        Result result = resultDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such result for given data"));
        return resultEntityToResultResponseDTOMapper.entityToDto(result);
    }

    @Override
    public List<ResultResponseDTO> getAllStageResults(){
        List<Result> results = resultDao.findAll();
        return results.stream()
                .map(resultEntityToResultResponseDTOMapper::entityToDto)
                .toList();
    }

    @Override
    public ResultResponseDTO delete(Long stageId , Long cyclistId){
        ResultKey id = generateResultKey(stageId,cyclistId);
        Result resToDelete= resultDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such result with given data"));
        resultDao.deleteById(id);
        return resultEntityToResultResponseDTOMapper.entityToDto(resToDelete);
    }


}
