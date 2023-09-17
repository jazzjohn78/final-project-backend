package com.rest.finalapp.domain.logs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginLogDto {

    private Long id;
    private String username;
    private String result;
}
