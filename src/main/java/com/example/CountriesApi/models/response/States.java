package com.example.CountriesApi.models.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class States implements Serializable {
    private String name;
    private String state_code;


}
