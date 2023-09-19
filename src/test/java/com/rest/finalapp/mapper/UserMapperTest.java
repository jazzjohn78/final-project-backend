package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.Player;
import com.rest.finalapp.domain.Team;
import com.rest.finalapp.domain.User;
import com.rest.finalapp.domain.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void testMapToUser() {
        //Given
        UserDto userDto = new UserDto(1L, "username", null, null);
        //When
        User user = userMapper.mapToUser(userDto);
        //Then
        assertEquals(1L, user.getId());
        assertEquals("username", user.getName());
    }

    @Test
    void testMapToUserDto() {
        //Given
        User user = new User(1l, "username");
        Player player = new Player(2L, "test name", "test rank", "test role");
        user.setPlayer(player);
        Team team = new Team(3L, "team name", "team desc");
        user.setTeam(team);
        //When
        UserDto userDto = userMapper.mapToUserDto(user);
        //Then
        assertEquals(1L, userDto.getId());
        assertEquals("username", userDto.getName());
        assertEquals(2L, userDto.getPlayerId());
        assertEquals(3L, userDto.getTeamId());
    }

    @Test
    void testMapToUserDtoList() {
        //Given
        List<User> userList = new ArrayList<>();
        User user = new User(1l, "username");
        Player player = new Player(2L, "test name", "test rank", "test role");
        user.setPlayer(player);
        Team team = new Team(3L, "team name", "team desc");
        user.setTeam(team);
        userList.add(user);
        //When
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(userList);
        //Then
        assertEquals(1, userDtoList.size());
        assertEquals(1L, userDtoList.get(0).getId());
        assertEquals("username", userDtoList.get(0).getName());
        assertEquals(2L, userDtoList.get(0).getPlayerId());
        assertEquals(3L, userDtoList.get(0).getTeamId());
    }

}