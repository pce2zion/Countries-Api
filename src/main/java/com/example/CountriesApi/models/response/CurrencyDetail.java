package com.example.CountriesApi.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CurrencyDetail {
    private String name;
    private String currency;
    private String iso2;
    private String iso3;
}
