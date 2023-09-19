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
@Entity(name = "LOGIN_LOG")
public class LoginLog {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "Date")
    private Date date;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "RESULT")
    private String result;

    public LoginLog(Long id, Date date, String username, String result) {
        this.id = id;
        this.date = date;
        this.username = username;
        this.result = result;
    }
}
