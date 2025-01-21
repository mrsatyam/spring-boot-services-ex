package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobileOnboardingRequest {
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
        private FetchCustomerRelationshipRequest fetchCustomerRelationshipRequest;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class FetchCustomerRelationshipRequest {
        private String encryptedRequest;
    }
}
