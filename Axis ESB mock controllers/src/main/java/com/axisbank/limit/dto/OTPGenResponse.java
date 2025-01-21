package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OTPGenResponse {
    private Response response;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Response {
        private Header header;
        private Body body;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Body {
        private GenerateOTPResponse generateOTPResponse;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class GenerateOTPResponse {
        private String encryptedResponse;
    }
}

