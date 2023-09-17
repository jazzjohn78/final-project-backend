package com.rest.finalapp.domain.logs.repository;

import com.rest.finalapp.domain.logs.LoginLog;
import org.springframework.data.repository.CrudRepository;

public interface LoginLogRepository extends CrudRepository<LoginLog, Long> {

    @Override
    LoginLog save(LoginLog loginLog);
}
