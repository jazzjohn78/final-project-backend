package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.dto.PlayerDto;
import org.springframework.stereotype.Service;

@Service
public class PlayerMapper {

    public Player mapToPlayer(final PlayerDto playerDto) {
        return new Player(
                playerDto.getId(),
                playerDto.getName(),
                playerDto.getRank(),
                playerDto.getRole()
        );
    }

    public PlayerDto mapToPlayerDto(final Player player) {
        return new PlayerDto(
                player.getId(),
                player.getName(),
                player.getRank(),
                player.getRole()
        );
    }
}
