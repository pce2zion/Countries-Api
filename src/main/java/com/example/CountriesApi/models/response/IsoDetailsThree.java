package com.example.CountriesApi.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class IsoDetailsThree {
    private String iso2;
    private String iso3;
}
