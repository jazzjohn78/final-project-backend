package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.Team;
import com.rest.finalapp.domain.dto.TeamDto;
import org.springframework.stereotype.Service;

@Service
public class TeamMapper {

    public Team mapToTeam(final TeamDto teamDto) {
        return new Team(
                teamDto.getId(),
                teamDto.getName(),
                teamDto.getDescription()
        );
    }

    public TeamDto mapToTeamDto(final Team team) {
        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getDescription()
        );
    }
}
