package com.rest.finalapp.domain.logs.repository;

import com.rest.finalapp.domain.logs.LoginErrorLog;
import org.springframework.data.repository.CrudRepository;

public interface LoginErrorLogRepository extends CrudRepository<LoginErrorLog, Long> {

    @Override
    LoginErrorLog save(LoginErrorLog loginErrorLog);
}
