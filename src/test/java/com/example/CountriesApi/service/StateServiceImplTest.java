package com.example.CountriesApi.service;

import com.example.CountriesApi.models.request.CountryReq;
import com.example.CountriesApi.models.response.OriginalResponseTwo;
import com.example.CountriesApi.models.response.States;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {StateServiceImpl.class})
@ExtendWith(SpringExtension.class)
class StateServiceImplTest {

    @Autowired
    private StateServiceImpl stateServiceImpl;


    @Test
    void testGetCountryStatesAndCities() {
        StateServiceImpl stateServiceImpl = new StateServiceImpl();
        stateServiceImpl.getCountryStatesAndCities(new CountryReq("GB"));
    }


    @Test
    void testGetCountryStatesAndCities2() {

        StateServiceImpl stateServiceImpl = new StateServiceImpl();
        CountryReq countryReq = mock(CountryReq.class);
        when(countryReq.getCountry()).thenReturn("GB");
        stateServiceImpl.getCountryStatesAndCities(countryReq);
    }


    @Test
    void testGetCountryStatesAndCities3() {
        OriginalResponseTwo actualCountryStatesAndCities = stateServiceImpl
                .getCountryStatesAndCities(new CountryReq("GB"));
        List<States> data = actualCountryStatesAndCities.getData();
        assertTrue(data.isEmpty());
        assertFalse(actualCountryStatesAndCities.isError());
        assertEquals("Failed to fetch data from the API", actualCountryStatesAndCities.getMsg());
        assertEquals(data, actualCountryStatesAndCities.getDataCity());
    }


    @Test
    void testGetCountryStatesAndCities4() {
        OriginalResponseTwo actualCountryStatesAndCities = stateServiceImpl
                .getCountryStatesAndCities(new CountryReq("GBR"));
        List<States> data = actualCountryStatesAndCities.getData();
        assertTrue(data.isEmpty());
        assertFalse(actualCountryStatesAndCities.isError());
        assertEquals("Failed to fetch data from the API", actualCountryStatesAndCities.getMsg());
        assertEquals(data, actualCountryStatesAndCities.getDataCity());
    }




}