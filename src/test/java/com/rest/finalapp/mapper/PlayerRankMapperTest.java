package com.rest.finalapp.mapper;

import com.rest.finalapp.domain.PlayerRank;
import com.rest.finalapp.domain.dto.PlayerRankDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerRankMapperTest {

    @Autowired
    PlayerRankMapper playerRankMapper;

    @Test
    void testMapToPlayerRank() {
        //Given
        PlayerRankDto playerRankDto = new PlayerRankDto(1l, "rank name");
        //When
        PlayerRank playerRank = playerRankMapper.mapToPlayerRank(playerRankDto);
        //Then
        assertEquals(1l, playerRank.getId());
        assertEquals("rank name", playerRank.getName());
    }

    @Test
    void testMapToPlayerRankDto() {
        //Given
        PlayerRank playerRank = new PlayerRank(1l, "rank name");
        //When
        PlayerRankDto playerRankDto = playerRankMapper.mapToPlayerRankDto(playerRank);
        //Then
        assertEquals(1l, playerRankDto.getId());
        assertEquals("rank name", playerRankDto.getName());
    }

    @Test
    void testMapToPlayerRankDtoList() {
        //Given
        List<PlayerRank> playerRankList = new ArrayList<>();
        PlayerRank playerRank = new PlayerRank(1l, "rank name");
        playerRankList.add(playerRank);
        //When
        List<PlayerRankDto> playerRankDtoList = playerRankMapper.mapToPlayerRankDtoList(playerRankList);
        //Then
        assertEquals(1, playerRankDtoList.size());
        assertEquals(1L, playerRankDtoList.get(0).getId());
        assertEquals("rank name", playerRankDtoList.get(0).getName());
    }

}