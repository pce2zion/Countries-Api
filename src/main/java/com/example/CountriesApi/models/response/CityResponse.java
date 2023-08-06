package com.example.CountriesApi.models.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CityResponse implements Serializable {
    private String city;
}
