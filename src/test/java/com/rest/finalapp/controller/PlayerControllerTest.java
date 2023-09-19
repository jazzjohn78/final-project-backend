package com.rest.finalapp.controller;

import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.dto.PlayerDto;
import com.rest.finalapp.domain.dto.UserDto;
import com.rest.finalapp.mapper.PlayerMapper;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private PlayerMapper playerMapper;

    @Test
    void shouldFetchPlayer() throws Exception {
        //Given
        PlayerDto playerDto = new PlayerDto(1L, "player 1", "rank 1", "role 1", null);
        Player player = new Player(2L, "player 2", "rank 2", "role 2");
        when(dbService.getPlayer(any(Long.class))).thenReturn(player);
        when(playerMapper.mapToPlayerDto(player)).thenReturn(playerDto);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/players/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("player 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rank", Matchers.is("rank 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role", Matchers.is("role 1")));
    }

    @Test
    void shouldDeletePlayer() throws Exception {
        //Given
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/players/111")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}