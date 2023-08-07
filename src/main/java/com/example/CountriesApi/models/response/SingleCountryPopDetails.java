package com.example.CountriesApi.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SingleCountryPopDetails {

  private boolean error;
  private String msg;
  private CountryDetailResponse data;

}
