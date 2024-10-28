package org.youcode.cch.team;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.cch.team.DTOs.CreateAndUpdateTeamDTO;
import org.youcode.cch.team.DTOs.TeamResponseDTO;
import org.youcode.cch.team.interfaces.TeamServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
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

    @PutMapping("/update/{id}")
    public ResponseEntity<TeamResponseDTO> updateTeam(@Valid @RequestBody CreateAndUpdateTeamDTO req ,@PathVariable("id") Long id){
        TeamResponseDTO res = teamService.update(req , id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable("id") Long id){
        TeamResponseDTO res = teamService.getTeamResponseById(id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams(){
       List<TeamResponseDTO> res = teamService.getAllTeams();
       return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TeamResponseDTO> deleteTeam(@PathVariable("id") Long id){
        TeamResponseDTO res = teamService.deleteById(id);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
}
