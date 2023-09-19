package com.rest.finalapp.controller;

import com.rest.finalapp.domain.PlayerRank;
import com.rest.finalapp.domain.dto.PlayerRankDto;
import com.rest.finalapp.mapper.PlayerRankMapper;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(PlayerRankController.class)
class PlayerRankControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private PlayerRankMapper playerRankMapper;

    @Test
    void shouldFetchPlayerRanks() throws Exception {
        //Given
        List<PlayerRankDto> playerRankDtos = List.of(new PlayerRankDto(1L, "rank 1"));
        List<PlayerRank> playerRanks = List.of(new PlayerRank(2L, "rank 2"));
        when(dbService.getAllPlayerRanks()).thenReturn(playerRanks);
        when(playerRankMapper.mapToPlayerRankDtoList(playerRanks)).thenReturn(playerRankDtos);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/playerRanks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("rank 1")));
    }

}