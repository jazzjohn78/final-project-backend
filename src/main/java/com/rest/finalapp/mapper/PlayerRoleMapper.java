package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.PlayerRole;
import com.rest.finalapp.domain.dto.PlayerRoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerRoleMapper {

    public PlayerRole mapToPlayerRole(final PlayerRoleDto playerRoleDto) {
        return new PlayerRole(
                playerRoleDto.getId(),
                playerRoleDto.getName()
        );
    }

    public PlayerRoleDto mapToPlayerRoleDto(final PlayerRole playerRole) {
        return new PlayerRoleDto(
                playerRole.getId(),
                playerRole.getName()
        );
    }

    public List<PlayerRoleDto> mapToPlayerRoleDtoList(final List<PlayerRole> playerRoleList) {
        return playerRoleList.stream()
                .map(this::mapToPlayerRoleDto)
                .toList();
    }
}
