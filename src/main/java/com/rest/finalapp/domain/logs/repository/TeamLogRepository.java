package com.rest.finalapp.domain.logs.repository;

import com.rest.finalapp.domain.logs.TeamLog;
import org.springframework.data.repository.CrudRepository;

public interface TeamLogRepository extends CrudRepository<TeamLog, Long> {

    @Override
    TeamLog save(TeamLog teamLog);
}
