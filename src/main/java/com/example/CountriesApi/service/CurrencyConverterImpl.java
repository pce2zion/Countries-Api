package com.example.CountriesApi.service;

import com.example.CountriesApi.models.request.CountryReq;
import com.example.CountriesApi.models.response.CurrencyConversionRate;
import com.example.CountriesApi.models.response.OriginalResponse;
import com.example.CountriesApi.models.response.SourceCurrency;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyConverterImpl {

    List<CurrencyConversionRate> conversionRates = new ArrayList<>();
    private void loadConversionRates() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/home/Desktop/CountriesApi 2/src/main/java/com/example/CountriesApi/exchange_rate (1).csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String sourceCurrency = parts[0];
                String targetCurrency = parts[1];
                double rate = Double.parseDouble(parts[2]);
                conversionRates.add(new CurrencyConversionRate(sourceCurrency, targetCurrency, rate));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double findConversionRate(String country, double amount, String targetCurrency) {
        loadConversionRates();

        String url = "https://countriesnow.space/api/v0.1/countries/currency";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> sourceCurrencyReqEntity = new HttpEntity<>(country, headers);
        CountryReq countryReq = CountryReq.builder().country(country)
                .build();
        ResponseEntity<SourceCurrency> responseEntity = restTemplate.postForEntity(url,
                countryReq,
                SourceCurrency.class);

            String sourceCurrency = "EUR";
        // String sourceCurrency = responseEntity.getBody().getData().getCurrency();

        if (sourceCurrency.equals(targetCurrency)) {
            return amount; // No conversion needed if the source and target currencies are the same.
        }
        else{
            for (CurrencyConversionRate rates : conversionRates) {
                if (rates.getSourceCurrency().equals(sourceCurrency) && rates.getTargetCurrency().equals(targetCurrency)) {
                    return rates.getRate() * amount;
                }
            }
        }

//        double conversionRate = findConversionRate(sourceCurrency, targetCurrency);
//        return amount * conversionRate;

        return 0; // If no conversion rate is found, return 0.
    }


}
