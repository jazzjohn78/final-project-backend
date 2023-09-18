package com.rest.finalapp.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkinDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Double priceUSD;

    @JsonProperty("img")
    private String imageSrc;

    @JsonProperty("pricePLN")
    private Double pricePLN;
}
