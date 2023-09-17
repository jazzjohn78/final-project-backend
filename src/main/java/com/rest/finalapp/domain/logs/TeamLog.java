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
@Entity(name = "TEAM_LOG")
public class TeamLog {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "TEAM_ID")
    private Long teamId;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "DETAILS")
    private String details;

    public TeamLog(Long id, Long teamId, String operation, String details) {
        this.id = id;
        this.teamId = teamId;
        this.operation = operation;
        this.details = details;
    }
}
