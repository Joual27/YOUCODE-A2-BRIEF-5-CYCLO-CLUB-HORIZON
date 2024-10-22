package org.youcode.cch.cyclist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.cch.cyclist.DTOs.CyclistResponseDTO;
import org.youcode.cch.cyclist.interfaces.CyclistServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cyclist")
public class CyclistController {

    private final CyclistServiceI cyclistService;

    public CyclistController(CyclistServiceI cyclistService){
        this.cyclistService = cyclistService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CyclistResponseDTO>> getAllCyclists(){
        List<CyclistResponseDTO> cyclists = cyclistService.getAllCyclists();
        if (cyclists.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cyclists, HttpStatus.OK);
    }
}
