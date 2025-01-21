package com.axisbank.limit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public final class SubHeader {
    @JsonProperty("requestUUID")
    private final String requestUUID;
    @JsonProperty("serviceRequestId")
    private final String serviceRequestId;
    @JsonProperty("serviceRequestVersion")
    private final String serviceRequestVersion;
    @JsonProperty("channelId")
    private final String channelId;

}
