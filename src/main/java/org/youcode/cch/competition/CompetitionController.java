package org.youcode.cch.competition;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.cch.competition.DTOs.CompetitionResponseDTO;
import org.youcode.cch.competition.DTOs.CreateAndUpdateCompetitionDTO;

@RestController
@RequestMapping("/api/v1/competitions")
public class CompetitionController {

    @PostMapping("/create")
    public ResponseEntity<CompetitionResponseDTO> createCompetition(@Valid @RequestBody CreateAndUpdateCompetitionDTO req){

    }
}
