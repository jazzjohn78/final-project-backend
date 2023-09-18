package com.rest.finalapp.client;

import com.rest.finalapp.domain.dto.CurrencyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class NbpClient {

    private final RestTemplate restTemplate;

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
