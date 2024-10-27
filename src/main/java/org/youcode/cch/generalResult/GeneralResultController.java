package org.youcode.cch.generalResult;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.cch.generalResult.DTOs.CreateGeneralResultDTO;
import org.youcode.cch.generalResult.DTOs.GeneralResultResponseDTO;
import org.youcode.cch.generalResult.interfaces.GeneralResultServiceI;

import java.util.List;


@RestController
@RequestMapping("/api/v1/general-results")
public class GeneralResultController {
    private final GeneralResultServiceI generalResultService;

    public GeneralResultController(GeneralResultServiceI generalResultService){
        this.generalResultService = generalResultService;
    }

    @PostMapping("/create")
    public ResponseEntity<GeneralResultResponseDTO> createGeneralResult(@Valid @RequestBody CreateGeneralResultDTO req){
        GeneralResultResponseDTO res = generalResultService.save(req);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @GetMapping("/{competitionId}/{cyclistId}")
    public ResponseEntity<GeneralResultResponseDTO> getGeneralResultOfCyclistInCompetition(@PathVariable("competitionId") Long competitionId , @PathVariable("cyclistId") Long cyclistId){
        GeneralResultResponseDTO res = generalResultService.getGeneralResultOfCyclistInCompetition(competitionId , cyclistId);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GeneralResultResponseDTO>> getAllGeneralResults(){
        List<GeneralResultResponseDTO> res = generalResultService.getAllGeneralResults();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{competitionId}/{cyclistId}")
    public ResponseEntity<GeneralResultResponseDTO> deleteGeneralResult(@PathVariable("competitionId") Long competitionId , @PathVariable("cyclistId") Long cyclistId){
        GeneralResultResponseDTO res = generalResultService.delete(competitionId , cyclistId);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
