package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobileOnboardingResponse {
    private Response response;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Response {
        private Header header;
        private Body body;
        private Error error;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Body {
        private FetchCustomerRelationshipResponse fetchCustomerRelationshipResponse;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class FetchCustomerRelationshipResponse {
        private String encryptedResponse;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Error {
        private String errorCode;
        private String message;
    }
}
