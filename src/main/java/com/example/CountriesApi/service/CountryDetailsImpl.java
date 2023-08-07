package com.example.CountriesApi.service;

import com.example.CountriesApi.models.request.CountryReq;
import com.example.CountriesApi.models.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CountryDetailsImpl {
    public OriginalResponseThree getSingleCountryPopulationDetails(CountryReq countryReq) {

        final String locationUrl = "https://countriesnow.space/api/v0.1/countries/positions";
        final String currencyUrl = "https://countriesnow.space/api/v0.1/countries/currency";
        final String populationUrl = "https://countriesnow.space/api/v0.1/countries/population";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CountryReq> locationRequestEntity = new HttpEntity<>(countryReq, headers);
        HttpEntity<CountryReq> currencyRequestEntity = new HttpEntity<>(countryReq, headers);
        HttpEntity<CountryReq> populationRequestEntity = new HttpEntity<>(countryReq, headers);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LocationResponse> locationResponseEntity = restTemplate.exchange(
                locationUrl,
                HttpMethod.POST,
                locationRequestEntity,
                LocationResponse.class
        );

        OriginalResponseThree originalResponse = new OriginalResponseThree();
        originalResponse.setPopulation(new ArrayList<>());


        if (locationResponseEntity.getStatusCode().is2xxSuccessful()) {
            LocationResponse singleLocationResponse = locationResponseEntity.getBody();
            if (singleLocationResponse != null && singleLocationResponse.getData() != null) {
                originalResponse.setError(false);
                originalResponse.setMsg(singleLocationResponse.getMsg());
                originalResponse.getLocation().setLat(singleLocationResponse.getData().getLat());
                originalResponse.getLocation().setLongi(singleLocationResponse.getData().getLongi());


                ResponseEntity<SingleCurrencyRes> SingleCurrencyResponseEntity = restTemplate.exchange(
                        currencyUrl,
                        HttpMethod.POST,
                        currencyRequestEntity,
                        SingleCurrencyRes.class
                );

                if (SingleCurrencyResponseEntity.getStatusCode().is2xxSuccessful()) {
                    SingleCurrencyRes singleCurrencyRes = SingleCurrencyResponseEntity.getBody();
                    if (singleCurrencyRes != null && singleCurrencyRes.getData() != null) {
                        originalResponse.setCurrency(singleCurrencyRes.getData().getCurrency());
                        originalResponse.getIso2And3().setIso2(singleCurrencyRes.getData().getIso2());
                        originalResponse.getIso2And3().setIso3(singleCurrencyRes.getData().getIso3());


                ResponseEntity<SingleCountryPopDetails> populationResponseEntity = restTemplate.exchange(
                        populationUrl,
                        HttpMethod.POST,
                        populationRequestEntity,
                        SingleCountryPopDetails.class
                );

                if (populationResponseEntity.getStatusCode().is2xxSuccessful()) {
                    SingleCountryPopDetails singleCurrencyPop = populationResponseEntity.getBody();
                    if (singleCurrencyRes != null && singleCurrencyRes.getData() != null) {


                        for(PopulationDetailsThree popDetails : singleCurrencyPop.getData().getPopulationCounts()){
                                 originalResponse.getPopulation().add(popDetails);
                        }
                    }
                     }
                    }

                }
            }
        }else {
            return null;
        }
        return originalResponse;
    }
}
