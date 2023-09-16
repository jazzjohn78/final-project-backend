package com.rest.finalapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerRoleDto {
    private Long id;
    private String name;
    private String description;
}
