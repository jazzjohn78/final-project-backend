package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.Team;
import com.rest.finalapp.domain.dto.PlayerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerMapperTest {

    @Autowired
    PlayerMapper playerMapper;

    @Test
    void testMapToPlayer() {
        //Given
        PlayerDto playerDto = new PlayerDto(1L, "test name", "test rank", "test role", null);
        //When
        Player player = playerMapper.mapToPlayer(playerDto);
        //Then
        assertEquals(1l, player.getId());
        assertEquals("test name", player.getName());
        assertEquals("test rank", player.getRank());
        assertEquals("test role", player.getRole());
    }

    @Test
    void testMapToPlayerDto() {
        //Given
        Player player = new Player(1L, "test name", "test rank", "test role");
        Team team = new Team(11L, "team name", "team description");
        player.setTeam(team);
        //When
        PlayerDto playerDto = playerMapper.mapToPlayerDto(player);
        //Then
        assertEquals(1l, playerDto.getId());
        assertEquals("test name", playerDto.getName());
        assertEquals("test rank", playerDto.getRank());
        assertEquals("test role", playerDto.getRole());
        assertEquals(11L, playerDto.getTeamId());
    }

}