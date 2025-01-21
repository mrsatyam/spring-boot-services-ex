package com.axisbank.limit.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PayeeVerificationResponse(
        @JsonProperty("RESP_CODE") String respCode,
        @JsonProperty("ERROR_REASON") String errorReason,
        @JsonProperty("REQUEST_ID") String requestId,
        @JsonProperty("RRN") String rrn,
        @JsonProperty("TRAN_DATE") String tranDate,
        @JsonProperty("BENE_NAME") String beneName,
        @JsonProperty("CHECKSUM") String checksum
) {
}