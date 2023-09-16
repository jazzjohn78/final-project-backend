package com.rest.finalapp.controller;

import com.rest.finalapp.controller.exception.PlayerNotFoundException;
import com.rest.finalapp.controller.exception.UserNotFoundException;
import com.rest.finalapp.domain.User;
import com.rest.finalapp.domain.dto.UserDto;
import com.rest.finalapp.mapper.UserMapper;
import com.rest.finalapp.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final DbService dbService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = dbService.getAllUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "{userName}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userName) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.mapToUserDto(dbService.getUser(userName)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        dbService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        dbService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{userId}")
    public void deleteUser(@PathVariable Long userId) {

    }
}
