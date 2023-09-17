package com.rest.finalapp.domain.logs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerLogDto {

    private Long id;
    private Long playerId;
    private String operation;
    private String details;
}
