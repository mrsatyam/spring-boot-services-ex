package com.example.finacleservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CloseFDRDRequest(Request request) {
    public record Request(Header header, Body body) {
    }

    public record SubHeader(
            String requestUUID,
            String serviceRequestId,
            String serviceRequestVersion,
            String channelId
    ) {
    }

    public record Header(
            SubHeader subHeader
    ) {
    }

    public record CloseRequest(
            String encryptedRequest
    ) {
    }

    public record Body(
            CloseRequest closeRequest
    ) {
    }

    public record RequestBodyWithAmount(
            String repaymentAccountId,
            String tdAccountId,
            String sourceSystemId,
            String amount
    ) {
    }

    public record RequestBodyWithoutAmount(
            String repaymentAccountId,
            String tdAccountId,
            String sourceSystemId
    ) {
    }

    public record PlainRequestWithAmt(
            @JsonProperty("requestBody")
            RequestBodyWithAmount requestBody
    ) {
    }

    public record PlainRequestWithoutAmt(
            @JsonProperty("requestBody")
            RequestBodyWithoutAmount requestBody
    ) {
    }
}

