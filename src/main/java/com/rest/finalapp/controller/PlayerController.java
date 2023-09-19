package com.rest.finalapp.controller;

import com.rest.finalapp.controller.exception.PlayerNotFoundException;
import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.dto.PlayerDto;
import com.rest.finalapp.mapper.PlayerMapper;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/players")
@RequiredArgsConstructor
public class PlayerController {

    private final DbService dbService;
    private final PlayerMapper playerMapper;


    @GetMapping(value = "{playerId}")
    public ResponseEntity<PlayerDto> getPlayer(@PathVariable Long playerId) throws PlayerNotFoundException {
        return ResponseEntity.ok(playerMapper.mapToPlayerDto(dbService.getPlayer(playerId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerDto>  createPlayer(@RequestBody PlayerDto playerDto) {
        Player player = playerMapper.mapToPlayer(playerDto);
        Player savedPlayer = dbService.savePlayer(player);
        return ResponseEntity.ok(playerMapper.mapToPlayerDto(savedPlayer));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePlayer(@RequestBody PlayerDto playerDto) {
        Player player = playerMapper.mapToPlayer(playerDto);
        dbService.savePlayer(player);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long playerId) {
        dbService.deletePlayer(playerId);
        return ResponseEntity.ok().build();
    }
}
