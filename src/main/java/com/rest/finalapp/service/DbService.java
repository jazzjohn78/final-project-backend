package com.rest.finalapp.service;

import com.rest.finalapp.controller.exception.PlayerNotFoundException;
import com.rest.finalapp.controller.exception.TeamNotFoundException;
import com.rest.finalapp.controller.exception.UserNotFoundException;
import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.PlayerRole;
import com.rest.finalapp.domain.Team;
import com.rest.finalapp.domain.User;
import com.rest.finalapp.repository.PlayerRepository;
import com.rest.finalapp.repository.PlayerRoleRepository;
import com.rest.finalapp.repository.TeamRepository;
import com.rest.finalapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerRoleRepository playerRoleRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(final String name) throws UserNotFoundException {
        return userRepository.findByName(name).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public Player getPlayer(final Long id) throws PlayerNotFoundException {
        return playerRepository.findById(id).orElseThrow(PlayerNotFoundException::new);
    }

    public Player savePlayer(final Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(final Long id) {
        playerRepository.deleteById(id);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    public Team getTeam(final Long id) throws TeamNotFoundException {
        return teamRepository.findById(id).orElseThrow(TeamNotFoundException::new);
    }

    public Team saveTeam(final Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(final Long id) {
        teamRepository.deleteById(id);
    }

    public List<PlayerRole> getAllPlayerRoles() {
        return playerRoleRepository.findAll();
    }

    public void saveRole(final PlayerRole playerRole) {
        playerRoleRepository.save(playerRole);
    }
}
