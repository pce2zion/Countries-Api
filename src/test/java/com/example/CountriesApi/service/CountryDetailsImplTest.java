package com.example.CountriesApi.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.CountriesApi.models.request.CountryReq;
import com.example.CountriesApi.models.response.OriginalResponseThree;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CountryDetailsImpl.class})
@ExtendWith(SpringExtension.class)
class CountryDetailsImplTest {
    @Autowired
    private CountryDetailsImpl countryDetailsImpl;


    @Test
    void testGetSingleCountryPopulationDetails() {
        countryDetailsImpl.getSingleCountryPopulationDetails(new CountryReq("GB"));
    }

    @Test
    void testGetSingleCountryPopulationDetails2() {
        countryDetailsImpl.getSingleCountryPopulationDetails(new CountryReq("GBR"));
    }


    @Test

    void testGetSingleCountryPopulationDetails3() {
        CountryReq countryReq = mock(CountryReq.class);
        when(countryReq.getCountry()).thenReturn("GB");
        countryDetailsImpl.getSingleCountryPopulationDetails(countryReq);
    }


}

