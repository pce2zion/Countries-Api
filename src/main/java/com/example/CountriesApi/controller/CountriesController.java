package com.example.CountriesApi.controller;
import com.example.CountriesApi.models.request.CityReq;
import com.example.CountriesApi.models.request.CountryReq;
import com.example.CountriesApi.service.CountryDetailsImpl;
import com.example.CountriesApi.service.CurrencyConverterImpl;
import com.example.CountriesApi.service.PopulationServiceImpl2;
import com.example.CountriesApi.service.StateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CountriesController {

    private final PopulationServiceImpl2 populationService;
    private final StateServiceImpl stateService;
    private final CurrencyConverterImpl currencyConverter;
    private final CountryDetailsImpl countryDetails;

    Logger logger = LoggerFactory.getLogger(CountriesController.class);

    @GetMapping("/highest-population/{numOfCities}")
    public ResponseEntity<?> getHighestPopulation(@PathVariable int numOfCities) {
        try {
            logger.info("Response is successful and gives a  list of countries and cities with the highest population ");
            return ResponseEntity.ok(populationService.getPopulationData(numOfCities));
        }catch(Exception e){
            logger.error("Bad request. Response throws and error");
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/convert")
    public ResponseEntity<?> findConversionRate(@RequestParam String country, @RequestParam double amount, @RequestParam String targetCurrency){
        try {
            logger.info("Response is successful and calculates the conversion rate of the currency ");
            return ResponseEntity.ok(currencyConverter.findConversionRate( country, amount, targetCurrency));
        }catch(Exception e){
            logger.error("Bad request. Response throws an error");
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/country/state")
    public ResponseEntity<?> getCountryStateAndCity( @RequestBody CountryReq countryReq) {
        try {
            logger.info("Response is successful and gives a single country and all cities with the highest population ");
        return ResponseEntity.ok(stateService.getCountryStatesAndCities( countryReq));
        }catch(Exception e){
            logger.error("Bad request. Response throws and error");
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping("/get-population/location/currency")
    public ResponseEntity<?> getSingleCountryPopulationDetails(@RequestBody CountryReq countryReq){
        try {
            logger.info("Response is successful and gives the details of a countries population, location and currency ");
        return ResponseEntity.ok(countryDetails.getSingleCountryPopulationDetails(countryReq));
        }catch(Exception e){
            logger.error("Bad request. Response throws an error");
            return ResponseEntity.badRequest().body(null);
        }
    }
}
