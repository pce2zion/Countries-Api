package com.example.CountriesApi.models.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class OriginalResponse implements Serializable {
    private boolean error;
    private String msg;
    private List<OriginalResponseData> data;
}
