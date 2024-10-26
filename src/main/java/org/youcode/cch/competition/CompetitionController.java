package org.youcode.cch.competition;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.cch.competition.DTOs.CompetitionResponseDTO;
import org.youcode.cch.competition.DTOs.CreateAndUpdateCompetitionDTO;
import org.youcode.cch.competition.interfaces.CompetitionServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competitions")
public class CompetitionController {

    private final CompetitionServiceI competitionService;

    public CompetitionController(CompetitionServiceI competitionService){
        this.competitionService = competitionService;
    }

    @PostMapping("/create")
    public ResponseEntity<CompetitionResponseDTO> createCompetition(@Valid @RequestBody CreateAndUpdateCompetitionDTO req){
          CompetitionResponseDTO res = competitionService.save(req);
          return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompetitionResponseDTO>> getAllCompetitions(){
        List<CompetitionResponseDTO> res = competitionService.getAllCompetitions();
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompetitionResponseDTO> updateCompetition(@RequestBody CreateAndUpdateCompetitionDTO req , @PathVariable("id") Long id){
        CompetitionResponseDTO res = competitionService.update(req , id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetitionResponseDTO> getCompetitionById(@PathVariable("id") Long id){
        CompetitionResponseDTO res = competitionService.getById(id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CompetitionResponseDTO> deleteCompetition(@PathVariable("id") Long id){
        CompetitionResponseDTO res = competitionService.deleteById(id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

}
