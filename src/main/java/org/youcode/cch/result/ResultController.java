package org.youcode.cch.result;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.DTOs.ResultResponseDTO;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.result.interfaces.ResultServiceI;

import java.util.List;

@RestController
@RequestMapping("api/v1/results")
public class ResultController {

    private final ResultServiceI resultService;

    public ResultController(ResultServiceI resultService){
        this.resultService = resultService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResultResponseDTO> createResult(@Valid @RequestBody CreateResultDTO createResultDTO){
         ResultResponseDTO res = resultService.save(createResultDTO);
         return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{stageId}/{cyclistId}")
    public ResponseEntity<ResultResponseDTO> getStageResultOfCyclist(@PathVariable("stageId") Long stageId , @PathVariable("cyclistId") Long cyclistId ){
        ResultResponseDTO res = resultService.getCyclistStageResult(stageId,cyclistId);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResultResponseDTO>> getAllStageResults(){
        List<ResultResponseDTO> res = resultService.getAllStageResults();
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{stageId}/{cyclistId}")
    public ResponseEntity<ResultResponseDTO> deleteResult(@PathVariable("stageId") Long stageId , @PathVariable("cyclistId") Long cyclistId){
        ResultResponseDTO res = resultService.delete(stageId,cyclistId);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
