package org.youcode.cch.stage;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.cch.stage.DTOs.CreateAndUpdateStageDTO;
import org.youcode.cch.stage.DTOs.StageResponseDTO;
import org.youcode.cch.stage.interfaces.StageServiceI;

@RestController
@RequestMapping("/api/v1/stages")
public class StageController {

    private final StageServiceI stageService;

    public StageController(StageServiceI stageService){
        this.stageService = stageService;
    }

    @PostMapping("/create")
    public ResponseEntity<StageResponseDTO> createStage(@RequestBody CreateAndUpdateStageDTO createAndUpdateStageDTO){
       try{
           StageResponseDTO createdStage = stageService.save(createAndUpdateStageDTO);
           return new ResponseEntity<>(createdStage , HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
