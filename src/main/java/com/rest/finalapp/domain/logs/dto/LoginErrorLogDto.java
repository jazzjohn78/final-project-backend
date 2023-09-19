package com.rest.finalapp.domain.logs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class LoginErrorLogDto {

    private Long id;
    private Date date;
    private String username;
    private String result;
}
