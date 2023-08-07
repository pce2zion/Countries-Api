package com.example.CountriesApi.service;

import com.example.CountriesApi.controller.CountriesController;
import com.example.CountriesApi.models.request.CountryReq;
import com.example.CountriesApi.models.response.CurrencyConversionRate;
import com.example.CountriesApi.models.response.SourceCurrency;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyConverterImpl {
    Logger logger = LoggerFactory.getLogger(CountriesController.class);
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

        CountryReq countryReq = CountryReq.builder().country(country)
                .build();
        HttpEntity<CountryReq> sourceCurrencyReqEntity = new HttpEntity<>(countryReq, headers);

        ResponseEntity<SourceCurrency> responseEntity = restTemplate.exchange(url,
               HttpMethod.POST,
                sourceCurrencyReqEntity,
                SourceCurrency.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            SourceCurrency sourceCurrency = responseEntity.getBody();
            if (sourceCurrency != null && sourceCurrency.getData() != null) {
                String sourceCurrency1 = responseEntity.getBody().getData().getCurrency();
                  //  String curr = "EUR";
                if (sourceCurrency1.equals(targetCurrency)) {
                    return amount;
                } else {
                    for (CurrencyConversionRate rates : conversionRates) {
                        if (rates.getSourceCurrency().equals(sourceCurrency1) && rates.getTargetCurrency().equals(targetCurrency)) {
                            return rates.getRate() * amount;
                        }
                        }
                    }
                }
                return 0.1;
            } else {
                return 0.2;
            }
        }


}
