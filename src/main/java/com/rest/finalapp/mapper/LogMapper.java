package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.logs.LoginLog;
import com.rest.finalapp.domain.logs.PlayerLog;
import com.rest.finalapp.domain.logs.TeamLog;
import com.rest.finalapp.domain.logs.dto.LoginLogDto;
import com.rest.finalapp.domain.logs.dto.PlayerLogDto;
import com.rest.finalapp.domain.logs.dto.TeamLogDto;
import org.springframework.stereotype.Service;

@Service
public class LogMapper {

    public LoginLog mapToLoginLog(final LoginLogDto loginLogDto) {
        return new LoginLog(
                loginLogDto.getId(),
                loginLogDto.getUsername(),
                loginLogDto.getResult()
        );
    }

    public TeamLog mapToTeamLog(final TeamLogDto teamLogDto) {
        return new TeamLog(
                teamLogDto.getId(),
                teamLogDto.getTeamId(),
                teamLogDto.getOperation(),
                teamLogDto.getDetails()
        );
    }

    public PlayerLog mapToPlayerLog(final PlayerLogDto playerLogDto) {
        return new PlayerLog(
                playerLogDto.getId(),
                playerLogDto.getPlayerId(),
                playerLogDto.getOperation(),
                playerLogDto.getDetails()
        );
    }
}
