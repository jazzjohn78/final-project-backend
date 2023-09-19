package com.rest.finalapp.controller;

import com.google.gson.Gson;
import com.rest.finalapp.domain.PlayerRole;
import com.rest.finalapp.domain.dto.PlayerRoleDto;
import com.rest.finalapp.mapper.PlayerRoleMapper;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(PlayerRoleController.class)
class PlayerRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private PlayerRoleMapper playerRoleMapper;

    @Test
    void shouldFetchPlayerRoles() throws Exception {
        //Given
        List<PlayerRoleDto> playerRoleDtos = List.of(new PlayerRoleDto(1L, "role 1"));
        List<PlayerRole> playerRoles = List.of(new PlayerRole(2L, "role 2"));
        when(dbService.getAllPlayerRoles()).thenReturn(playerRoles);
        when(playerRoleMapper.mapToPlayerRoleDtoList(playerRoles)).thenReturn(playerRoleDtos);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/playerRoles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("role 1")));
    }

    @Test
    void shouldCreatePlayerRole() throws Exception {
        //Given
        PlayerRoleDto playerRoleDto = new PlayerRoleDto(1L, "role 1");
        PlayerRole playerRole = new PlayerRole(2L, "role 2");
        when(playerRoleMapper.mapToPlayerRole(any(PlayerRoleDto.class))).thenReturn(playerRole);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(playerRoleDto);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/playerRoles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}