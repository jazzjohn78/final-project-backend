package com.rest.finalapp.client;

import com.rest.finalapp.domain.dto.SkinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class SkinClient {

    private final RestTemplate restTemplate;
    private final SkinConfig skinConfig;


    public SkinDto getRandomSkin() {
        URI url = UriComponentsBuilder.fromHttpUrl(skinConfig.getSkinApiEndpoint() + "/randomclass/Rifle")
                .build().encode().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", skinConfig.getSkinApiKey());
        headers.set("X-RapidAPI-Host", skinConfig.getSkinApiHost());

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        try {
            ResponseEntity<SkinDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, SkinDto.class);
            return response.getBody();
        } catch (RestClientException e) {
            return null;
        }
    }
}
