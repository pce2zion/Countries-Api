package com.example.CountriesApi.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopulationCountResponse  implements Serializable {
    private String  year;
    private String value;
    private String sex;
    private String reliability;
}
