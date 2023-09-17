package com.rest.finalapp.mapper;

import com.rest.finalapp.controller.exception.PlayerNotFoundException;
import com.rest.finalapp.controller.exception.TeamNotFoundException;
import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.Team;
import com.rest.finalapp.domain.dto.TeamDto;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamMapper {

    private final DbService dbService;

    public Team mapToTeam(final TeamDto teamDto) {
        Team team = new Team(
                teamDto.getId(),
                teamDto.getName(),
                teamDto.getDescription()
        );

        for(Long playerId : teamDto.getPlayersIds()) {
            try {
                Player player = dbService.getPlayer(playerId);
                player.setTeam(team);
                team.getPlayers().add(player);
            } catch (PlayerNotFoundException e) {

            }
        }

        return team;
    }

    public TeamDto mapToTeamDto(final Team team) {
        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getDescription(),
                team.getPlayers().stream()
                        .map(player -> player.getId())
                        .collect(Collectors.toList())
        );
    }

    public List<TeamDto> mapToTeamDtoList(final List<Team> teamList) {
        return teamList.stream()
                .map(this::mapToTeamDto)
                .toList();
    }
}
