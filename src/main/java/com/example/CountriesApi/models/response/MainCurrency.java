package com.example.CountriesApi.models.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MainCurrency implements Serializable {
     private String name;
     private String currency;
     private String iso2;
     private String iso3;
}
