package com.example.CountriesApi.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class LocationResponse {
        private boolean error;
        private String msg;
        private SingleLocation data;
}
