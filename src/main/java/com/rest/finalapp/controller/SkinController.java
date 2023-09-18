package com.rest.finalapp.controller;

import com.rest.finalapp.client.NbpClient;
import com.rest.finalapp.client.SkinClient;
import com.rest.finalapp.domain.dto.SkinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/skin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SkinController {

    private final SkinClient skinClient;
    private final NbpClient nbpClient;

    @GetMapping("random")
    public SkinDto getRandomSkin() {
        SkinDto randomSkin = skinClient.getRandomSkin();
        Double plnValue = nbpClient.getUsdPln() * randomSkin.getPriceUSD();
        randomSkin.setPricePLN(plnValue);
        return randomSkin;
    }
}
