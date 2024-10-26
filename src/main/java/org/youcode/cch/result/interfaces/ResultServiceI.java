package org.youcode.cch.result.interfaces;

import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.DTOs.ResultResponseDTO;
import org.youcode.cch.result.Result;
import org.youcode.cch.result.embeddables.ResultKey;

import java.util.List;

public interface ResultServiceI {
    ResultKey generateResultKey(Long stageId, Long cyclistId);
    int assignRankToResult(Result resultOnCreation);
    ResultResponseDTO save(CreateResultDTO result);
    ResultResponseDTO getCyclistStageResult(Long stageId , Long cyclistId);
    List<ResultResponseDTO> getAllStageResults();
    ResultResponseDTO delete(Long stageId , Long cyclistId);
}
