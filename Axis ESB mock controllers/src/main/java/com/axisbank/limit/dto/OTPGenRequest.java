package com.axisbank.limit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OTPGenRequest {

    @JsonProperty("request")
    private Request request;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Request {
        private Header header;
        private Body body;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Body {
        private GenerateOTPRequest generateOTPRequest;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class GenerateOTPRequest {
        private String encryptedRequest;
    }
}

