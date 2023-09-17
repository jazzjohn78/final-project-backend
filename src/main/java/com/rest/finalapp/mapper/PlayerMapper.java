package com.rest.finalapp.mapper;

import com.rest.finalapp.controller.exception.TeamNotFoundException;
import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.dto.PlayerDto;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerMapper {

    private final DbService dbService;

    public Player mapToPlayer(final PlayerDto playerDto) {
        Player player = new Player(
                playerDto.getId(),
                playerDto.getName(),
                playerDto.getRank(),
                playerDto.getRole()
        );

        if(playerDto.getTeamId() != null) {
            try {
                player.setTeam(dbService.getTeam(playerDto.getTeamId()));
            } catch (TeamNotFoundException e) {

            }
        }

        return player;
    }

    public PlayerDto mapToPlayerDto(final Player player) {
        return new PlayerDto(
                player.getId(),
                player.getName(),
                player.getRank(),
                player.getRole(),
                player.getTeam() != null ? player.getTeam().getId() : null
        );
    }
}
