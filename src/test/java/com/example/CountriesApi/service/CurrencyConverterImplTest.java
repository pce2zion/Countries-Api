package com.example.CountriesApi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.CountriesApi.models.response.CurrencyConversionRate;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CurrencyConverterImpl.class})
@ExtendWith(SpringExtension.class)
class CurrencyConverterImplTest {
    @Autowired
    private CurrencyConverterImpl currencyConverterImpl;


    @Test
    void testFindConversionRate3() {
        assertEquals(0.2d, currencyConverterImpl.findConversionRate("GB", 10.0d, "GBP"));
        List<CurrencyConversionRate> currencyConversionRateList = currencyConverterImpl.conversionRates;
        CurrencyConversionRate getResult = currencyConversionRateList.get(1423);
        assertEquals(4.0d, getResult.getRate());
        CurrencyConversionRate getResult1 = currencyConversionRateList.get(1422);
        assertEquals("JPY", getResult1.getSourceCurrency());
        assertEquals("UGX", getResult1.getTargetCurrency());
        CurrencyConversionRate getResult2 = currencyConversionRateList.get(1421);
        assertEquals(3.0d, getResult2.getRate());
        assertEquals("USD", getResult2.getSourceCurrency());
        assertEquals(26.62d, getResult1.getRate());
        assertEquals("UGX", getResult.getTargetCurrency());
        assertEquals("GBP", getResult.getSourceCurrency());
        assertEquals("UGX", getResult2.getTargetCurrency());
    }


    @Test
    void testFindConversionRate4() {
        assertEquals(0.2d, currencyConverterImpl.findConversionRate("GBR", 10.0d, "GBP"));
        List<CurrencyConversionRate> currencyConversionRateList = currencyConverterImpl.conversionRates;
        CurrencyConversionRate getResult = currencyConversionRateList.get(1455);
        assertEquals(4.0d, getResult.getRate());
        CurrencyConversionRate getResult1 = currencyConversionRateList.get(1454);
        assertEquals("JPY", getResult1.getSourceCurrency());
        assertEquals("UGX", getResult1.getTargetCurrency());
        CurrencyConversionRate getResult2 = currencyConversionRateList.get(1453);
        assertEquals(3.0d, getResult2.getRate());
        assertEquals("USD", getResult2.getSourceCurrency());
        assertEquals(26.62d, getResult1.getRate());
        assertEquals("UGX", getResult.getTargetCurrency());
        assertEquals("GBP", getResult.getSourceCurrency());
        assertEquals("UGX", getResult2.getTargetCurrency());
    }
}

