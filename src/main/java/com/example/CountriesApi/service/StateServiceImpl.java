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
public class StateServiceImpl {

    public OriginalResponseTwo getCountryStatesAndCities(CountryReq countryReq) {
        final String stateUrl = "https://countriesnow.space/api/v0.1/countries/states";
        final String cityUrl = "https://countriesnow.space/api/v0.1/countries/state/cities";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CountryReq> stateRequestEntity = new HttpEntity<>(countryReq, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SingleCountryResponse> stateResponseEntity = restTemplate.exchange(
                stateUrl,
                HttpMethod.POST,
                stateRequestEntity,
                SingleCountryResponse.class
        );

        OriginalResponseTwo originalResponse = new OriginalResponseTwo();
        originalResponse.setData(new ArrayList<>());
        originalResponse.setDataCity(new ArrayList<>());

        if (stateResponseEntity.getStatusCode().is2xxSuccessful()) {
            SingleCountryResponse singleCountryResponse = stateResponseEntity.getBody();
            if (singleCountryResponse != null && singleCountryResponse.getData() != null) {
                originalResponse.setError(false);
                originalResponse.setMsg("Success");



                for (States state : singleCountryResponse.getData().getStates()) {
                    CountryReq cityRequest = new CountryReq();
                    cityRequest.setCountry(countryReq.getCountry());
                    cityRequest.setState(countryReq.getState());
                    originalResponse.getData().add(state);

                    HttpEntity<CountryReq> cityRequestEntity = new HttpEntity<>(cityRequest, headers);

                    ResponseEntity<StateCityResponse> cityResponseEntity = restTemplate.exchange(
                            cityUrl,
                            HttpMethod.POST,
                            cityRequestEntity,
                            StateCityResponse.class
                    );

                    if (cityResponseEntity.getStatusCode().is2xxSuccessful()) {
                        StateCityResponse cityResponse = cityResponseEntity.getBody();
                        if (cityResponse != null && cityResponse.getData() != null) {
                            for (CityResponse city : cityResponse.getData()) {
                                originalResponse.getDataCity().add(city);
                            }
                        }
                    } else {
                        // Handle error if necessary.
                    }
                }
            } else {
                originalResponse.setError(true);
                originalResponse.setMsg("No states found for the given country");
            }
        } else {
            // Handle error if necessary.
            originalResponse.setError(false);
            originalResponse.setMsg("Failed to fetch data from the API");
        }

        return originalResponse;
    }



}
