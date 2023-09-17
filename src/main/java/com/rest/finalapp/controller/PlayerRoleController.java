package com.rest.finalapp.controller;

import com.rest.finalapp.domain.PlayerRole;
import com.rest.finalapp.domain.dto.PlayerRoleDto;
import com.rest.finalapp.mapper.PlayerRoleMapper;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/playerRoles")
@RequiredArgsConstructor
public class PlayerRoleController {

    private final DbService dbService;
    private final PlayerRoleMapper playerRoleMapper;

    @GetMapping
    public ResponseEntity<List<PlayerRoleDto>> getPlayerRoles() {
        List<PlayerRole> playerRoles = dbService.getAllPlayerRoles();
        return ResponseEntity.ok(playerRoleMapper.mapToPlayerRoleDtoList(playerRoles));
    }

    @GetMapping(value = "{playerRoleId}")
    public PlayerRoleDto getPlayerRole(@PathVariable Long playerRoleId) {
        return new PlayerRoleDto(1L, "In Game Leader");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPlayerRole(@RequestBody PlayerRoleDto playerRoleDto) {
        PlayerRole playerRole = playerRoleMapper.mapToPlayerRole(playerRoleDto);
        dbService.saveRole(playerRole);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public PlayerRoleDto updatePlayerRole(PlayerRoleDto playerRoleDto) {
        return new PlayerRoleDto(1L, "In Game Leader");
    }

    @DeleteMapping(value = "{playerRoleId}")
    public void deletePlayerRole(@PathVariable Long playerRoleId) {

    }
}
