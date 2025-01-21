package com.axisbank.limit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class Address {
    @JsonProperty("mailingAddress")
    private final String mailingAddress;
    @JsonProperty("commonAddress1")
    private final String commonAddress1;
    @JsonProperty("commonAddress2")
    private final String commonAddress2;
    @JsonProperty("commonAddress3")
    private final String commonAddress3;

}
