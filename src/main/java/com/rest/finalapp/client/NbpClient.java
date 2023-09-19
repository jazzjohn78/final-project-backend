package com.rest.finalapp.client;

import com.rest.finalapp.domain.dto.CurrencyDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class NbpClient {

    private static NbpClient nbpClient;
    private final RestTemplate restTemplate;

    private NbpClient() {
        this.restTemplate = new RestTemplate();
    }

    public static NbpClient getInstance() {
        if (nbpClient == null) {
            nbpClient = new NbpClient();
        }
        return nbpClient;
    }

    public Double getUsdPln() {
        URI url = UriComponentsBuilder.fromHttpUrl("http://api.nbp.pl/api/exchangerates/rates/A/USD")
                .build().encode().toUri();

        try {
            CurrencyDto currencyDtoResponse = restTemplate.getForObject(url, CurrencyDto.class);
            return currencyDtoResponse.getRates().get(0).getMidRate();
        } catch (RestClientException e) {
            return null;
        }
    }
}
