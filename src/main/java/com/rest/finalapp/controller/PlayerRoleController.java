package com.rest.finalapp.controller;

import com.rest.finalapp.domain.dto.PlayerRoleDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/playerRoles")
public class PlayerRoleController {
    @GetMapping
    public List<PlayerRoleDto> getPlayerRoles() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{playerRoleId}")
    public PlayerRoleDto getPlayerRole(@PathVariable Long playerRoleId) {
        return new PlayerRoleDto(1L, "IGL", "In Game Leader");
    }

    @PostMapping
    public void createPlayerRole(PlayerRoleDto playerRoleDto) {

    }

    @PutMapping
    public PlayerRoleDto updatePlayerRole(PlayerRoleDto playerRoleDto) {
        return new PlayerRoleDto(1L, "IGL", "In Game Leader");
    }

    @DeleteMapping(value = "{playerRoleId}")
    public void deletePlayerRole(@PathVariable Long playerRoleId) {

    }
}
