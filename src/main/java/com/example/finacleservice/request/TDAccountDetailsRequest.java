package com.example.finacleservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TDAccountDetailsRequest(Request request) {

    public record Request(Header header, Body body) {}

    public record Header(@JsonProperty("subHeader") SubHeader subHeader) {}

    public record SubHeader(
            @JsonProperty("requestUUID") String requestUUID,
            @JsonProperty("serviceRequestId") String serviceRequestId,
            @JsonProperty("serviceRequestVersion") String serviceRequestVersion,
            @JsonProperty("channelId") String channelId) {}

    public record Body(@JsonProperty("getTDAccountDetailsRequest") GetTDAccountDetailsRequest getTDAccountDetailsRequest) {}

    public record GetTDAccountDetailsRequest(@JsonProperty("encryptedRequest") String encryptedRequest) {}
}
