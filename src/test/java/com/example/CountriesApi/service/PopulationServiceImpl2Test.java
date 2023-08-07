package com.example.CountriesApi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.example.CountriesApi.models.response.OriginalResponse;
import com.example.CountriesApi.models.response.OriginalResponseData;
import com.example.CountriesApi.models.response.PopulationCountResponse;

import java.util.List;

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

    @Test
    void testGetPopulationData3() {
        OriginalResponse actualPopulationData = populationServiceImpl2.getPopulationData(10);
        List<OriginalResponseData> data = actualPopulationData.getData();
        assertEquals(10, data.size());
        assertFalse(actualPopulationData.isError());
        assertEquals("all cities with population", actualPopulationData.getMsg());
        assertEquals(17, data.get(2).getPopulationCounts().size());
        List<PopulationCountResponse> populationCounts = data.get(0).getPopulationCounts();
        assertEquals(12, populationCounts.size());
        List<PopulationCountResponse> populationCounts1 = data.get(9).getPopulationCounts();
        assertEquals(12, populationCounts1.size());
        List<PopulationCountResponse> populationCounts2 = data.get(8).getPopulationCounts();
        assertEquals(12, populationCounts2.size());
        List<PopulationCountResponse> populationCounts3 = data.get(7).getPopulationCounts();
        assertEquals(12, populationCounts3.size());
        assertEquals(1, data.get(1).getPopulationCounts().size());
        PopulationCountResponse getResult = populationCounts.get(1);
        assertEquals("Both Sexes", getResult.getSex());
        PopulationCountResponse getResult1 = populationCounts1.get(11);
        assertEquals("Both Sexes", getResult1.getSex());
        assertEquals("2001", getResult1.getYear());
        PopulationCountResponse getResult2 = populationCounts2.get(10);
        assertEquals("2003", getResult2.getYear());
        PopulationCountResponse getResult3 = populationCounts.get(0);
        assertEquals("2012", getResult3.getYear());
        assertEquals("2011", getResult.getYear());
        assertEquals("Both Sexes", getResult3.getSex());
        assertEquals("2626553", getResult3.getValue());
        PopulationCountResponse getResult4 = populationCounts3.get(11);
        assertEquals("Both Sexes", getResult4.getSex());
        assertEquals("686722", getResult4.getValue());
        assertEquals("601338", getResult2.getValue());
        assertEquals("2001", getResult4.getYear());
        assertEquals("Both Sexes", getResult2.getSex());
        assertEquals("371217", getResult1.getValue());
        assertEquals("2617175", getResult.getValue());
    }


    @Test
    void testGetPopulationData4() {
        OriginalResponse actualPopulationData = populationServiceImpl2.getPopulationData(1);
        List<OriginalResponseData> data = actualPopulationData.getData();
        assertEquals(1, data.size());
        assertFalse(actualPopulationData.isError());
        assertEquals("all cities with population", actualPopulationData.getMsg());
        List<PopulationCountResponse> populationCounts = data.get(0).getPopulationCounts();
        assertEquals(12, populationCounts.size());
        PopulationCountResponse getResult = populationCounts.get(0);
        assertEquals("2012", getResult.getYear());
        PopulationCountResponse getResult1 = populationCounts.get(1);
        assertEquals("2011", getResult1.getYear());
        assertEquals("2617175", getResult1.getValue());
        assertEquals("Both Sexes", getResult1.getSex());
        assertEquals("2626553", getResult.getValue());
        assertEquals("Both Sexes", getResult.getSex());
        PopulationCountResponse getResult2 = populationCounts.get(10);
        assertEquals("2542003", getResult2.getValue());
        assertEquals("Both Sexes", getResult2.getSex());
        PopulationCountResponse getResult3 = populationCounts.get(11);
        assertEquals("2546804", getResult3.getValue());
        assertEquals("Both Sexes", getResult3.getSex());
        assertEquals("2003", getResult2.getYear());
        assertEquals("2001", getResult3.getYear());
    }
}

