package com.rest.finalapp.controller;

import com.rest.finalapp.domain.dto.PlayerRankDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/playerRanks")
public class PlayerRankController {

    @GetMapping
    public List<PlayerRankDto> getPlayerRanks() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{playerRankId}")
    public PlayerRankDto getPlayerRank(@PathVariable Long playerRankId) {
        return new PlayerRankDto(1L, "MG2", "Master Guardian II");
    }

    @PostMapping
    public void createPlayerRank(PlayerRankDto playerRankDto) {

    }

    @PutMapping
    public PlayerRankDto updatePlayerRank(PlayerRankDto playerRankDto) {
        return new PlayerRankDto(1L, "MG2", "Master Guardian II");
    }

    @DeleteMapping(value = "{playerRankId}")
    public void deletePlayerRank(@PathVariable Long playerRankId) {

    }
}
