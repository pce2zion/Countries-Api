package com.example.CountriesApi.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SingleLocation {
    private String name;
    private String iso2;
    private int longi;
    private int lat;
}
