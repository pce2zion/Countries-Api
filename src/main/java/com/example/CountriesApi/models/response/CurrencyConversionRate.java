package com.example.CountriesApi.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CurrencyConversionRate {
    private String sourceCurrency;
    private String targetCurrency;
    private double rate;
}
