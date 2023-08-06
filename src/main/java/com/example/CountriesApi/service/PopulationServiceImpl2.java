package com.example.CountriesApi.service;

import com.example.CountriesApi.models.request.CityReq;
import com.example.CountriesApi.models.request.CountryReq;
import com.example.CountriesApi.models.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PopulationServiceImpl2 {

    public OriginalResponse getPopulationData(int numOfCities) {
        final String url = "https://countriesnow.space/api/v0.1/countries/population/cities";


        List<OriginalResponseData> newCountries = new ArrayList<>();
        List<OriginalResponseData> newsCountries = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OriginalResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, OriginalResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<OriginalResponseData> response = responseEntity.getBody().getData();

            for (int i = 0; i < response.size(); i++) {
                String country = response.get(i).getCountry().toLowerCase();
                if (country.equals("italy") || country.equals("ghana") || country.equals("new zealand")) {
                    newCountries.add(response.get(i));
                }
            }

            Collections.sort(newCountries, Comparator.comparingLong(data -> Long.parseLong(data.getPopulationCounts().get(0).getValue())));
            Collections.reverse(newCountries);


            int citiesToInclude = Math.min(numOfCities, newCountries.size());
            for (int j = 0; j < citiesToInclude; j++) {
                newsCountries.add(newCountries.get(j));
            }

            OriginalResponse finalResponse = OriginalResponse.builder()
                    .data(newsCountries)
                    .error(responseEntity.getBody().isError())
                    .msg(responseEntity.getBody().getMsg())
                    .build();
            return finalResponse;
        } else {
            return null;
        }
    }


}

