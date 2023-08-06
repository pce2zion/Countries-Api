package com.example.CountriesApi.models.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SingleCountryResponse implements Serializable {
        private boolean error;
        private String msg;
        private StateResponse data;
}
