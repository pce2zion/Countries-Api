package com.example.CountriesApi.models.response;

import com.example.CountriesApi.models.response.PopulationCountResponse;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class OriginalResponseData implements Serializable {
    private String city;
    private String country;
    private List<PopulationCountResponse> populationCounts;
}
