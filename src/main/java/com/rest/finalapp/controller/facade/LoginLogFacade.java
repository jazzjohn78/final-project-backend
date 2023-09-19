package com.rest.finalapp.controller.facade;

import com.rest.finalapp.domain.logs.LoginErrorLog;
import com.rest.finalapp.domain.logs.LoginLog;
import com.rest.finalapp.domain.logs.dto.LoginLogDto;
import com.rest.finalapp.mapper.LogMapper;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginLogFacade {

    private final LoginLogValidator loginLogValidator;
    private final LogMapper logMapper;
    private final DbService dbService;

    public void processLoginLogCreation(LoginLogDto loginLogDto) {
        if(loginLogValidator.isLoginSuccessful(loginLogDto)) {
            LoginLog loginLog = logMapper.mapToLoginLog(loginLogDto);
            dbService.saveLoginLog(loginLog);
        } else {
            LoginErrorLog loginErrorLog = logMapper.mapToLoginErrorLog(loginLogDto);
            dbService.saveLoginErrorLog(loginErrorLog);
        }
    }
}
