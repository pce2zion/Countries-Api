package com.example.CountriesApi.models.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CurrencyConverter {
    private List<CurrencyConversionRate> conversionRates;
}
