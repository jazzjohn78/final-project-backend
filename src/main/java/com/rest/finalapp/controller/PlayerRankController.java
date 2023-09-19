package com.rest.finalapp.controller;

import com.rest.finalapp.domain.PlayerRank;
import com.rest.finalapp.domain.dto.PlayerRankDto;
import com.rest.finalapp.mapper.PlayerRankMapper;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPlayerRank(@RequestBody PlayerRankDto playerRankDto) {
        PlayerRank playerRank = playerRankMapper.mapToPlayerRank(playerRankDto);
        dbService.saveRank(playerRank);
        return ResponseEntity.ok().build();
    }
}
