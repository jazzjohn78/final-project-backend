package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.logs.LoginErrorLog;
import com.rest.finalapp.domain.logs.LoginLog;
import com.rest.finalapp.domain.logs.PlayerLog;
import com.rest.finalapp.domain.logs.TeamLog;
import com.rest.finalapp.domain.logs.dto.LoginLogDto;
import com.rest.finalapp.domain.logs.dto.PlayerLogDto;
import com.rest.finalapp.domain.logs.dto.TeamLogDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LogMapperTest {

    @Autowired
    private LogMapper logMapper;


    @Test
    void testMapToLoginLog() {
        //Given
        LoginLogDto loginLogDto = new LoginLogDto(1L, new Date(1L), "test username", "test result");
        //When
        LoginLog loginLog = logMapper.mapToLoginLog(loginLogDto);
        //Then
        assertEquals(1, loginLog.getId());
        assertEquals(new Date(1L), loginLog.getDate());
        assertEquals("test username", loginLog.getUsername());
        assertEquals("test result", loginLog.getResult());
    }

    @Test
    void testMapToLoginErrorLog() {
        //Given
        LoginLogDto loginLogDto = new LoginLogDto(1L, new Date(1L), "test username", "test result");
        //When
        LoginErrorLog loginErrorLog = logMapper.mapToLoginErrorLog(loginLogDto);
        //Then
        assertEquals(1, loginErrorLog.getId());
        assertEquals(new Date(1L), loginErrorLog.getDate());
        assertEquals("test username", loginErrorLog.getUsername());
        assertEquals("test result", loginErrorLog.getResult());
    }

    @Test
    void testMapToTeamLog() {
        //Given
        TeamLogDto teamLogDto = new TeamLogDto(1L, new Date(1L), 2L, "test operation", "test details");
        //When
        TeamLog teamLog = logMapper.mapToTeamLog(teamLogDto);
        //Then
        assertEquals(1, teamLog.getId());
        assertEquals(new Date(1L), teamLog.getDate());
        assertEquals(2l, teamLog.getTeamId());
        assertEquals("test operation", teamLog.getOperation());
        assertEquals("test details", teamLog.getDetails());
    }

    @Test
    void testMapToPlayerLog() {
        //Given
        PlayerLogDto playerLogDto = new PlayerLogDto(1L, new Date(1L), 2L, "test operation", "test details");
        //When
        PlayerLog playerLog = logMapper.mapToPlayerLog(playerLogDto);
        //Then
        assertEquals(1, playerLog.getId());
        assertEquals(new Date(1L), playerLog.getDate());
        assertEquals(2l, playerLog.getPlayerId());
        assertEquals("test operation", playerLog.getOperation());
        assertEquals("test details", playerLog.getDetails());
    }

}