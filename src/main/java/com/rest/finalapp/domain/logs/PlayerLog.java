package com.rest.finalapp.domain.logs;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity(name = "PLAYER_LOG")
public class PlayerLog {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "PLAYER_ID")
    private Long playerId;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "DETAILS")
    private String details;

    public PlayerLog(Long id, Long playerId, String operation, String details) {
        this.id = id;
        this.playerId = playerId;
        this.operation = operation;
        this.details = details;
    }
}
