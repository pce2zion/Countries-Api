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
public class StateResponse implements Serializable {
     private String name;
     private String iso3;
     private List<States> states;

}
