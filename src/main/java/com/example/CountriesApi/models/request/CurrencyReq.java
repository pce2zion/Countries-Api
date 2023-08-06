package com.example.CountriesApi.models.request;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Setter
public class CurrencyReq implements Serializable {
    private String country;
}
