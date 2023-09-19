package com.rest.finalapp.domain.logs;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity(name = "TEAM_LOG")
public class TeamLog {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "Date")
    private Date date;

    @Column(name = "TEAM_ID")
    private Long teamId;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "DETAILS")
    private String details;

    public TeamLog(Long id, Date date, Long teamId, String operation, String details) {
        this.id = id;
        this.date = date;
        this.teamId = teamId;
        this.operation = operation;
        this.details = details;
    }
}
