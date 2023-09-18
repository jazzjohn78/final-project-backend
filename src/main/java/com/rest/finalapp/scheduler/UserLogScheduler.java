package com.rest.finalapp.scheduler;

import com.rest.finalapp.domain.logs.UserLog;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserLogScheduler {

    private final DbService dbService;

    @Scheduled(cron = "0 0 0 * * *")
    public void saveUserCountToLog() {
        int userCount = dbService.getAllUsers().size();
        dbService.saveUserLog(new UserLog(
                new Date(),
                userCount
        ));
    }
}
