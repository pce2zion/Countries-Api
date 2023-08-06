package com.example.CountriesApi.models.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SourceCurrency implements Serializable {
    private boolean error;
    private String message;
    private MainCurrency data;
}
