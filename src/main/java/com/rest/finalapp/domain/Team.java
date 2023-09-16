package com.rest.finalapp.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "TEAMS")
public class Team {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    /*private List<Long> players;*/

    public Team(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
