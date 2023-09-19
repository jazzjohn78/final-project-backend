package com.rest.finalapp.controller.facade;

import com.rest.finalapp.domain.logs.dto.LoginLogDto;
import org.springframework.stereotype.Component;

@Component
public class LoginLogValidator {

    public boolean isLoginSuccessful(LoginLogDto loginLogDto) {
        if (loginLogDto.getResult().contains("success")) {
            return true;
        }
        return false;
    }
}
