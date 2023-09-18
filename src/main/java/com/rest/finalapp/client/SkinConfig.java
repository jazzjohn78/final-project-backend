package com.rest.finalapp.client;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SkinConfig {

    @Value("${csskin.api.endpoint}")
    private String skinApiEndpoint;

    @Value("${csskin.api.key}")
    private String skinApiKey;

    @Value("${csskin.api.host}")
    private String skinApiHost;
}
