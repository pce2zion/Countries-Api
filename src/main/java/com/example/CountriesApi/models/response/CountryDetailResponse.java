package com.example.CountriesApi.models.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CountryDetailResponse {
    private String country;
    private String code;
    private String iso3;
    private List<PopulationDetailsThree> populationCounts;

}
