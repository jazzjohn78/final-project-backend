package com.rest.finalapp.domain;

import com.rest.finalapp.domain.dto.PlayerDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PLAYERS")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "PLAYER_RANK")
    private String rank;
    @Column(name = "ROLE")
    private String role;

    public Player(Long id, String name, String rank, String role) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.role = role;
    }
}
