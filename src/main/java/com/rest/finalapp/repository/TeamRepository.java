package com.rest.finalapp.repository;

import com.rest.finalapp.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {

    @Override
    List<Team> findAll();

    @Override
    Team save(Team team);

    @Override
    Optional<Team> findById(Long id);

    @Override
    void deleteById(Long id);
}
