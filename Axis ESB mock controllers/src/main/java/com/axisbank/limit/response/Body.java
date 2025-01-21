package com.axisbank.limit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Body {
    @JsonProperty("fetchDemographicDetailsResponse")
    private FetchDemographicDetailsResponse fetchDemographicDetailsResponse;

}
