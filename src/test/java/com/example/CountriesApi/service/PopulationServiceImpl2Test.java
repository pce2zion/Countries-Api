package com.example.CountriesApi.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PopulationServiceImpl2.class})
@ExtendWith(SpringExtension.class)
class PopulationServiceImpl2Test {
    @Autowired
    private PopulationServiceImpl2 populationServiceImpl2;

    /**
     * Method under test: {@link PopulationServiceImpl2#getPopulationData(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPopulationData() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        populationServiceImpl2.getPopulationData(10);
    }

    /**
     * Method under test: {@link PopulationServiceImpl2#getPopulationData(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPopulationData2() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        populationServiceImpl2.getPopulationData(1);
    }
}

