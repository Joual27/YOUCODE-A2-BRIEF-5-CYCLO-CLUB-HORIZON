package org.youcode.cch.stage;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.cch.stage.DTOs.CreateAndUpdateStageDTO;
import org.youcode.cch.stage.DTOs.StageResponseDTO;
import org.youcode.cch.stage.interfaces.StageServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stages")
public class StageController {

    private final StageServiceI stageService;
    public StageController(StageServiceI stageService){
        this.stageService = stageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StageResponseDTO>> fetchAllStages(){
        List<StageResponseDTO> res = stageService.getAllStages();
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<StageResponseDTO> createStage(@Valid @RequestBody CreateAndUpdateStageDTO req){
        StageResponseDTO createdStage = stageService.save(req);
        return new ResponseEntity<>(createdStage , HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StageResponseDTO> updateStage(@PathVariable("id") Long id , @Valid  @RequestBody CreateAndUpdateStageDTO req){
        StageResponseDTO updatedStage = stageService.update(id , req);
        return new ResponseEntity<>(updatedStage , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageResponseDTO> fetchStageById(@PathVariable("id") Long id){
        StageResponseDTO res = stageService.getStageById(id);
        return new ResponseEntity<>(res , HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StageResponseDTO> deleteStage(@PathVariable("id") Long id){
        StageResponseDTO res = stageService.deleteById(id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }


}
