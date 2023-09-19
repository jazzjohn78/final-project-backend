package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.Team;
import com.rest.finalapp.domain.dto.TeamDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeamMapperTest {

    @Autowired
    TeamMapper teamMapper;

    @Test
    void testMapToTeam() {
        //Given
        TeamDto teamDto = new TeamDto(1L, "name", "description", new ArrayList<>());
        //When
        Team team = teamMapper.mapToTeam(teamDto);
        //Then
        assertEquals(1l, team.getId());
        assertEquals("name", team.getName());
        assertEquals("description", team.getDescription());
    }

    @Test
    void testMapToTeamDto() {
        //Given
        Team team = new Team(1L, "name", "description");
        Player player = new Player(2L, "player 1", "rank", "role");
        team.getPlayers().add(player);
        //When
        TeamDto teamDto = teamMapper.mapToTeamDto(team);
        //Then
        assertEquals(1l, teamDto.getId());
        assertEquals("name", teamDto.getName());
        assertEquals("description", teamDto.getDescription());
        assertEquals(1, teamDto.getPlayersIds().size());
        assertEquals(2L, teamDto.getPlayersIds().get(0));
    }

    @Test
    void testMapToTeamDtoList() {
        //Given
        List<Team> teamList = new ArrayList<>();
        Team team = new Team(1L, "name", "description");
        Player player = new Player(2L, "player 1", "rank", "role");
        team.getPlayers().add(player);
        teamList.add(team);
        //When
        List<TeamDto> teamDtoList = teamMapper.mapToTeamDtoList(teamList);
        //Then
        assertEquals(1, teamDtoList.size());
        assertEquals(1L, teamDtoList.get(0).getId());
        assertEquals("name", teamDtoList.get(0).getName());
        assertEquals("description", teamDtoList.get(0).getDescription());
        assertEquals(2L, teamDtoList.get(0).getPlayersIds().get(0));
    }

}