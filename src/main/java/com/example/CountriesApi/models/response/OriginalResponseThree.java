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
public class OriginalResponseThree implements Serializable {
    private boolean error;
    private String msg;
    private List<PopulationDetailsThree> population;
    private LocationThree location;
     private String currency;
    private IsoDetailsThree iso2And3;

}
