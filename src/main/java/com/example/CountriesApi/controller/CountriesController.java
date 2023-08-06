package com.example.CountriesApi.controller;
import com.example.CountriesApi.models.request.CityReq;
import com.example.CountriesApi.models.request.CountryReq;
import com.example.CountriesApi.service.CurrencyConverterImpl;
import com.example.CountriesApi.service.PopulationServiceImpl2;
import com.example.CountriesApi.service.StateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CountriesController {

    private final PopulationServiceImpl2 populationService;

    private final StateServiceImpl stateService;

    private final CurrencyConverterImpl currencyConverter;

    @GetMapping("/highest-population/{numOfCities}")
    public ResponseEntity<?> getHighestPopulation(@PathVariable int numOfCities) {
         return ResponseEntity.ok(populationService.getPopulationData(numOfCities));
    }

    @GetMapping("/country/state")
    public ResponseEntity<?> getCountryStateAndCity( @RequestBody CountryReq countryReq) {
        return ResponseEntity.ok(stateService.getCountryStatesAndCities( countryReq));
    }

    @GetMapping("/convert")
    public ResponseEntity<?> findConversionRate(@RequestParam String country, @RequestParam double amount, @RequestParam String targetCurrency){
        return ResponseEntity.ok(currencyConverter.findConversionRate( country, amount, targetCurrency));
    }
}
