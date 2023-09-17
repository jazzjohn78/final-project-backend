package com.rest.finalapp.repository;

import com.rest.finalapp.domain.PlayerRank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRankRepository extends CrudRepository<PlayerRank, Long> {

    @Override
    List<PlayerRank> findAll();

    @Override
    PlayerRank save(PlayerRank playerRank);
}
