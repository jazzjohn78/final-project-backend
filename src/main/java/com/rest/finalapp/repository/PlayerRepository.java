package com.rest.finalapp.repository;

import com.rest.finalapp.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Override
    List<Player> findAll();

    @Override
    Player save(Player player);

    @Override
    Optional<Player> findById(Long id);

    @Override
    void deleteById(Long id);
}
