package com.axisbank.limit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseBody {
    @JsonProperty("header")
    private final Header header;
    @JsonProperty("body")
    private final Body body;

}
