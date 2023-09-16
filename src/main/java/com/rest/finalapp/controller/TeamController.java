package com.rest.finalapp.controller;

import com.rest.finalapp.domain.dto.TeamDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/teams")
public class TeamController {

    @GetMapping
    public List<TeamDto> getTeams() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{teamId}")
    public TeamDto getTeam(@PathVariable Long teamId) {
        return new TeamDto(1L, "smartfingers", "Teamwork makes the dream work", new ArrayList<>());
    }

    @PostMapping
    public void createTeam(TeamDto teamDto) {

    }

    @PutMapping
    public TeamDto updateTeam(TeamDto teamDto) {
        return new TeamDto(1l, "smarterfingers", "There's no I in TEAM", new ArrayList<>());
    }

    @DeleteMapping(value = "{teamId}")
    public void deleteTeam(@PathVariable Long teamId) {

    }
}
