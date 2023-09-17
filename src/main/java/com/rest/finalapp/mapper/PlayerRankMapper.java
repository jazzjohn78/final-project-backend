package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.PlayerRank;
import com.rest.finalapp.domain.dto.PlayerRankDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerRankMapper {

    public PlayerRank mapToPlayerRank(final PlayerRankDto playerRankDto) {
        return new PlayerRank(
                playerRankDto.getId(),
                playerRankDto.getName()
        );
    }

    public PlayerRankDto mapToPlayerRankDto(final PlayerRank playerRank) {
        return new PlayerRankDto(
                playerRank.getId(),
                playerRank.getName()
        );
    }

    public List<PlayerRankDto> mapToPlayerRankDtoList(final List<PlayerRank> playerRankList) {
        return playerRankList.stream()
                .map(this::mapToPlayerRankDto)
                .toList();
    }
}
