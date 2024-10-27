package org.youcode.cch.team;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.cch.team.DTOs.CreateAndUpdateTeamDTO;
import org.youcode.cch.team.DTOs.TeamResponseDTO;
import org.youcode.cch.team.interfaces.TeamServiceI;

@RestController
@RequestMapping("api/v1/teams")
public class TeamController {
    private final TeamServiceI teamService;

    public TeamController(TeamServiceI teamService){
       this.teamService = teamService;
    }
    @PostMapping("/create")
    public ResponseEntity<TeamResponseDTO> createTeam(@Valid @RequestBody CreateAndUpdateTeamDTO req){
        TeamResponseDTO res = teamService.save(req);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
}
