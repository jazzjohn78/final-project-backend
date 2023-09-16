package com.rest.finalapp.service;

import com.rest.finalapp.controller.exception.PlayerNotFoundException;
import com.rest.finalapp.controller.exception.UserNotFoundException;
import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.User;
import com.rest.finalapp.repository.PlayerRepository;
import com.rest.finalapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;

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
}
