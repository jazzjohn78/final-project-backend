package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.PlayerRole;
import com.rest.finalapp.domain.dto.PlayerRoleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerRoleMapperTest {

    @Autowired
    PlayerRoleMapper playerRoleMapper;

    @Test
    void testMapToPlayerRole() {
        //Given
        PlayerRoleDto playerRoleDto = new PlayerRoleDto(1l, "role name");
        //When
        PlayerRole playerRole = playerRoleMapper.mapToPlayerRole(playerRoleDto);
        //Then
        assertEquals(1l, playerRole.getId());
        assertEquals("role name", playerRole.getName());
    }

    @Test
    void testMapToPlayerRoleDto() {
        //Given
        PlayerRole playerRole = new PlayerRole(1l, "role name");
        //When
        PlayerRoleDto playerRoleDto = playerRoleMapper.mapToPlayerRoleDto(playerRole);
        //Then
        assertEquals(1l, playerRoleDto.getId());
        assertEquals("role name", playerRoleDto.getName());
    }

    @Test
    void testMapToPlayerRoleDtoList() {
        //Given
        List<PlayerRole> playerRoleList = new ArrayList<>();
        PlayerRole playerRole = new PlayerRole(1l, "role name");
        playerRoleList.add(playerRole);
        //When
        List<PlayerRoleDto> playerRoleDtoList = playerRoleMapper.mapToPlayerRoleDtoList(playerRoleList);
        //Then
        assertEquals(1, playerRoleDtoList.size());
        assertEquals(1L, playerRoleDtoList.get(0).getId());
        assertEquals("role name", playerRoleDtoList.get(0).getName());
    }

}