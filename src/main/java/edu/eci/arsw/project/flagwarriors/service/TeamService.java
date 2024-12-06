package edu.eci.arsw.project.flagwarriors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.eci.arsw.project.flagwarriors.model.Team;
import edu.eci.arsw.project.flagwarriors.repository.PlayerRepository;
import edu.eci.arsw.project.flagwarriors.repository.TeamRepository;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
 
    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
    }

    public Team getTeamById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null); 
    }
    
    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

     public List<Team> getAllteams() {
        return teamRepository.findAll();
    }

    public Team saveTeam(Team team) {
       return teamRepository.save(team);
    }
    public void delete(){
        teamRepository.deleteAll();
    }
}
