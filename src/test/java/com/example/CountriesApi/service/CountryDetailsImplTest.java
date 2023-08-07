package com.example.CountriesApi.service;

import com.example.CountriesApi.models.request.CountryReq;
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

    /**
     * Method under test: {@link CountryDetailsImpl#getSingleCountryPopulationDetails(CountryReq)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSingleCountryPopulationDetails() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        countryDetailsImpl.getSingleCountryPopulationDetails(new CountryReq("GB"));
    }

    /**
     * Method under test: {@link CountryDetailsImpl#getSingleCountryPopulationDetails(CountryReq)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSingleCountryPopulationDetails2() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        countryDetailsImpl.getSingleCountryPopulationDetails(new CountryReq("GBR"));
    }
}

