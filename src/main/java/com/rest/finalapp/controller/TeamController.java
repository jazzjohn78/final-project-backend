package com.rest.finalapp.controller;

import com.rest.finalapp.controller.exception.TeamNotFoundException;
import com.rest.finalapp.domain.Team;
import com.rest.finalapp.domain.dto.TeamDto;
import com.rest.finalapp.mapper.TeamMapper;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final DbService dbService;
    private final TeamMapper teamMapper;

    @GetMapping
    public List<TeamDto> getTeams() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{teamId}")
    public ResponseEntity<TeamDto> getTeam(@PathVariable Long teamId) throws TeamNotFoundException {
        return ResponseEntity.ok(teamMapper.mapToTeamDto(dbService.getTeam(teamId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        Team team = teamMapper.mapToTeam(teamDto);
        Team createdTeam = dbService.saveTeam(team);
        return ResponseEntity.ok(teamMapper.mapToTeamDto(createdTeam));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateTeam(@RequestBody TeamDto teamDto) {
        Team team = teamMapper.mapToTeam(teamDto);
        dbService.saveTeam(team);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamId) {
        dbService.deleteTeam(teamId);
        return ResponseEntity.ok().build();
    }
}
