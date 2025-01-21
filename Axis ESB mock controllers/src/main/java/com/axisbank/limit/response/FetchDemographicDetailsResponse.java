package com.axisbank.limit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FetchDemographicDetailsResponse {
    @JsonProperty("responseBody")
    private final ResponseBodyDetails responseBodyDetails;

}
