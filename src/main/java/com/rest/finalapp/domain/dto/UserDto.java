package com.rest.finalapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Long playerId;
    private Long teamId;
}
