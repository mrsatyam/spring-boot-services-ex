package com.example.finacleservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TDAccountDetailsResponse(Response response) {

    public static record Response(Header header, Body body) {}

    public static record Header(@JsonProperty("subHeader") SubHeader subHeader) {}

    public static record SubHeader(
            @JsonProperty("requestUUID") String requestUUID,
            @JsonProperty("serviceRequestId") String serviceRequestId,
            @JsonProperty("serviceRequestVersion") String serviceRequestVersion,
            @JsonProperty("channelId") String channelId) {}

    public static record Body(@JsonProperty("getTDAccountDetailsResponse") GetTDAccountDetailsResponse getTDAccountDetailsResponse) {}

    public static record GetTDAccountDetailsResponse(@JsonProperty("encryptedResponse") String encryptedResponse) {}
}
