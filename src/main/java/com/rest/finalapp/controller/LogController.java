package com.rest.finalapp.controller;

import com.rest.finalapp.domain.logs.LoginLog;
import com.rest.finalapp.domain.logs.PlayerLog;
import com.rest.finalapp.domain.logs.TeamLog;
import com.rest.finalapp.domain.logs.dto.LoginLogDto;
import com.rest.finalapp.domain.logs.dto.PlayerLogDto;
import com.rest.finalapp.domain.logs.dto.TeamLogDto;
import com.rest.finalapp.mapper.LogMapper;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/logs")
@RequiredArgsConstructor
public class LogController {

    private final DbService dbService;
    private final LogMapper logMapper;

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createLoginLog(@RequestBody LoginLogDto loginLogDto) {
        LoginLog loginLog = logMapper.mapToLoginLog(loginLogDto);
        dbService.saveLoginLog(loginLog);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "team", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTeamLog(@RequestBody TeamLogDto teamLogDto) {
        TeamLog teamLog = logMapper.mapToTeamLog(teamLogDto);
        dbService.saveTeamLog(teamLog);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "player", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPlayerLog(@RequestBody PlayerLogDto playerLogDto) {
        PlayerLog playerLog = logMapper.mapToPlayerLog(playerLogDto);
        dbService.savePlayerLog(playerLog);
        return ResponseEntity.ok().build();
    }
}
