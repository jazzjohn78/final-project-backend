package com.rest.finalapp.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(
            targetEntity = Player.class,
            mappedBy = "team",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Player> players = new ArrayList<>();

    public Team(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
