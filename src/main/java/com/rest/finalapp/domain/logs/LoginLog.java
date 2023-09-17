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
@Entity(name = "LOGIN_LOG")
public class LoginLog {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "RESULT")
    private String result;

    public LoginLog(Long id, String username, String result) {
        this.id = id;
        this.username = username;
        this.result = result;
    }
}
