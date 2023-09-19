package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.logs.LoginErrorLog;
import com.rest.finalapp.domain.logs.LoginLog;
import com.rest.finalapp.domain.logs.PlayerLog;
import com.rest.finalapp.domain.logs.TeamLog;
import com.rest.finalapp.domain.logs.dto.LoginErrorLogDto;
import com.rest.finalapp.domain.logs.dto.LoginLogDto;
import com.rest.finalapp.domain.logs.dto.PlayerLogDto;
import com.rest.finalapp.domain.logs.dto.TeamLogDto;
import org.springframework.stereotype.Service;

@Service
public class LogMapper {

    public LoginLog mapToLoginLog(final LoginLogDto loginLogDto) {
        return new LoginLog(
                loginLogDto.getId(),
                loginLogDto.getDate(),
                loginLogDto.getUsername(),
                loginLogDto.getResult()
        );
    }

    public LoginErrorLog mapToLoginErrorLog(final LoginErrorLogDto loginErrorLogDto) {
        return new LoginErrorLog(
                loginErrorLogDto.getId(),
                loginErrorLogDto.getDate(),
                loginErrorLogDto.getUsername(),
                loginErrorLogDto.getResult()
        );
    }

    public TeamLog mapToTeamLog(final TeamLogDto teamLogDto) {
        return new TeamLog(
                teamLogDto.getId(),
                teamLogDto.getDate(),
                teamLogDto.getTeamId(),
                teamLogDto.getOperation(),
                teamLogDto.getDetails()
        );
    }

    public PlayerLog mapToPlayerLog(final PlayerLogDto playerLogDto) {
        return new PlayerLog(
                playerLogDto.getId(),
                playerLogDto.getDate(),
                playerLogDto.getPlayerId(),
                playerLogDto.getOperation(),
                playerLogDto.getDetails()
        );
    }
}
