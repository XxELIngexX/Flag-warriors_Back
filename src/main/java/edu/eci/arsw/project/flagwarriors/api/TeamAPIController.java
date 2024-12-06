package edu.eci.arsw.project.flagwarriors.api;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.eci.arsw.project.flagwarriors.model.Team;
import edu.eci.arsw.project.flagwarriors.service.TeamService;



@RestController
@RequestMapping("/api/teams")
public class TeamAPIController {

    private final TeamService teamService;

    public TeamAPIController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {  // Cambiar el nombre del método
        List<Team> teams = teamService.getAllteams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return new ResponseEntity<>(teamService.saveTeam(team), HttpStatus.CREATED);
    }
   

    

    @GetMapping("/name/{name}")
    public ResponseEntity<Team> getTeam(@PathVariable String name) {
        Team team = teamService.getTeamByName(name);
        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
