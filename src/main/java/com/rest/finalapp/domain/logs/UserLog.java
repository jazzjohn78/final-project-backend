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
@Entity(name = "USER_LOG")
public class UserLog {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "Date")
    private Date date;

    @Column(name = "USER_COUNT")
    private Integer userCount;

    public UserLog(Date date, Integer userCount) {
        this.date = date;
        this.userCount = userCount;
    }
}
