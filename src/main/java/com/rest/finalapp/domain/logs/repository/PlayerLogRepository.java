package com.rest.finalapp.domain.logs.repository;

import com.rest.finalapp.domain.logs.PlayerLog;
import org.springframework.data.repository.CrudRepository;

public interface PlayerLogRepository extends CrudRepository<PlayerLog, Long> {

    @Override
    PlayerLog save(PlayerLog playerLog);
}
