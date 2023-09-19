package com.rest.finalapp.controller;

import com.google.gson.Gson;
import com.rest.finalapp.domain.User;
import com.rest.finalapp.domain.dto.UserDto;
import com.rest.finalapp.mapper.UserMapper;
import com.rest.finalapp.service.DbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private UserMapper userMapper;

    @Test
    void shouldFetchEmptyUsers() throws Exception {
        //Given
        when(dbService.getAllUsers()).thenReturn(List.of());
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldFetchUsers() throws Exception {
        //Given
        List<UserDto> userDtos = List.of(new UserDto(1L, "username 1", null, null));
        List<User> users = List.of(new User(2L, "username 2"));
        when(dbService.getAllUsers()).thenReturn(users);
        when(userMapper.mapToUserDtoList(users)).thenReturn(userDtos);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("username 1")));
    }

    @Test
    void shouldFetchUser() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "username1", null, null);
        User user = new User(2L, "username2");
        when(dbService.getUser(any(String.class))).thenReturn(user);
        when(userMapper.mapToUserDto(user)).thenReturn(userDto);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/users/username2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("username1")));
    }

    @Test
    void shouldCreateUser() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "name 1", null, null);
        User user = new User(2L, "name 2");
        when(userMapper.mapToUser(any(UserDto.class))).thenReturn(user);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldUpdateUser() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "name 1", null, null);
        User user = new User(2L, "name 2");
        when(userMapper.mapToUser(any(UserDto.class))).thenReturn(user);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}