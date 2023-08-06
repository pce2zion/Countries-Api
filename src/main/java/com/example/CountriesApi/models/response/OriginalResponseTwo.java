package com.example.CountriesApi.models.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class OriginalResponseTwo {
    private boolean error;
    private String msg;
    private List<States> data;
    private List<CityResponse> dataCity;
}
