package com.example.CountriesApi.models.request;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CityReq implements Serializable {
    private String country;
    private String state;
}
