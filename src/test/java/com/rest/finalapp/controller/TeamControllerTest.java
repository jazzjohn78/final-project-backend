package com.rest.finalapp.controller;

import com.rest.finalapp.domain.Team;
import com.rest.finalapp.domain.dto.TeamDto;
import com.rest.finalapp.mapper.TeamMapper;
import com.rest.finalapp.service.DbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(TeamController.class)
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private TeamMapper teamMapper;

    @Test
    void shouldFetchTeams() throws Exception {
        //Given
        List<TeamDto> teamDtos = List.of(new TeamDto(1L, "team name 1", "team desc 1", List.of()));
        List<Team> teams = List.of(new Team(2L, "team name 2", "team desc 2"));
        when(dbService.getAllTeams()).thenReturn(teams);
        when(teamMapper.mapToTeamDtoList(teams)).thenReturn(teamDtos);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/teams")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("team name 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description", Matchers.is("team desc 1")));
    }

    @Test
    void shouldFetchTeam() throws Exception {
        //Given
        TeamDto teamDto = new TeamDto(1L, "team name 1", "team desc 1", List.of());
        Team team = new Team(2L, "team name 2", "team desc 2");
        when(dbService.getTeam(any(Long.class))).thenReturn(team);
        when(teamMapper.mapToTeamDto(team)).thenReturn(teamDto);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/teams/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("team name 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is("team desc 1")));
    }

    @Test
    void shouldDeleteTeam() throws Exception {
        //Given
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/teams/222")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}