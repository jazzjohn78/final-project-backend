package com.rest.finalapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeamDto {
    private Long id;
    private String name;
    private String description;
    private List<Long> players;
}
