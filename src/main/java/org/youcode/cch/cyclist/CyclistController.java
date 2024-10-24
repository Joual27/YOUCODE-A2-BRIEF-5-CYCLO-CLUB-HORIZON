package org.youcode.cch.cyclist;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.cch.cyclist.DTOs.CreateAndUpdateCyclistDTO;
import org.youcode.cch.cyclist.DTOs.CyclistResponseDTO;
import org.youcode.cch.cyclist.interfaces.CyclistServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cyclists")
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

    @PostMapping("/create")
    public ResponseEntity<CyclistResponseDTO> createCyclist(@Valid @RequestBody CreateAndUpdateCyclistDTO createAndUpdateCyclistDTO){
        CyclistResponseDTO res = cyclistService.save(createAndUpdateCyclistDTO);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CyclistResponseDTO> updateCyclist(@PathVariable("id") Long id, @Valid @RequestBody CreateAndUpdateCyclistDTO createAndUpdateCyclistDTO){
        CyclistResponseDTO res = cyclistService.update(id , createAndUpdateCyclistDTO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CyclistResponseDTO> updateCyclist(@PathVariable("id") Long id){
        CyclistResponseDTO res = cyclistService.deleteById(id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CyclistResponseDTO> getCyclistById(@PathVariable("id") Long id){
        CyclistResponseDTO res = cyclistService.getCyclistById(id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

}
