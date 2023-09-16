package com.rest.finalapp.mapper;

import com.rest.finalapp.controller.exception.PlayerNotFoundException;
import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.User;
import com.rest.finalapp.domain.dto.UserDto;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final DbService dbService;

    public User mapToUser(final UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getName()
        );

        if(userDto.getPlayerId() != null) {
            try {
                user.setPlayer(dbService.getPlayer(userDto.getPlayerId()));
            } catch (PlayerNotFoundException e) {

            }
        }

        return user;

    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPlayer() != null ? user.getPlayer().getId() : null,
                user.getTeamId()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .toList();
    }
}
