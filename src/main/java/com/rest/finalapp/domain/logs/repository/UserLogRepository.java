package com.rest.finalapp.domain.logs.repository;

import com.rest.finalapp.domain.logs.UserLog;
import org.springframework.data.repository.CrudRepository;

public interface UserLogRepository extends CrudRepository<UserLog, Long> {

    @Override
    UserLog save(UserLog userLog);
}
