package com.rest.finalapp.controller;

import com.rest.finalapp.domain.PlayerRank;
import com.rest.finalapp.domain.dto.PlayerRankDto;
import com.rest.finalapp.mapper.PlayerRankMapper;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/playerRanks")
@RequiredArgsConstructor
public class PlayerRankController {

    private final DbService dbService;
    private final PlayerRankMapper playerRankMapper;

    @GetMapping
    public ResponseEntity<List<PlayerRankDto>> getPlayerRanks() {
        List<PlayerRank> playerRanks = dbService.getAllPlayerRanks();
        return ResponseEntity.ok(playerRankMapper.mapToPlayerRankDtoList(playerRanks));
    }

    @GetMapping(value = "{playerRankId}")
    public PlayerRankDto getPlayerRank(@PathVariable Long playerRankId) {
        return new PlayerRankDto(1L, "Master Guardian II");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPlayerRank(@RequestBody PlayerRankDto playerRankDto) {
        PlayerRank playerRank = playerRankMapper.mapToPlayerRank(playerRankDto);
        dbService.saveRank(playerRank);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public PlayerRankDto updatePlayerRank(PlayerRankDto playerRankDto) {
        return new PlayerRankDto(1L, "Master Guardian II");
    }

    @DeleteMapping(value = "{playerRankId}")
    public void deletePlayerRank(@PathVariable Long playerRankId) {

    }
}
