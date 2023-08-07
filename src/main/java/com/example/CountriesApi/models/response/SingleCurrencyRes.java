package com.example.CountriesApi.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SingleCurrencyRes {
        private String error;
        private String msg;
        private CurrencyDetail data;
}
