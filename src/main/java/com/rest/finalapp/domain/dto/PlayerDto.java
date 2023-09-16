package com.rest.finalapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerDto {
    private Long id;
    private String name;
    private String rank;
    private String role;

}
