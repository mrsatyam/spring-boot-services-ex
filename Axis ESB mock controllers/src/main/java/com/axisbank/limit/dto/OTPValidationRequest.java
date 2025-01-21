package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OTPValidationRequest {
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
        private ValidationOTPRequest validateOTPRequest;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ValidationOTPRequest {
        private String encryptedRequest;
    }
}

