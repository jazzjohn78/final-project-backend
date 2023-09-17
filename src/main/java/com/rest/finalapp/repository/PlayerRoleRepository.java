package com.rest.finalapp.repository;

import com.rest.finalapp.domain.PlayerRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRoleRepository extends CrudRepository<PlayerRole, Long> {

    @Override
    List<PlayerRole> findAll();

    @Override
    PlayerRole save(PlayerRole playerRole);
}
