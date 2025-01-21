package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OTPValidationResponseBody {
    private ValidationResponseBody responseBody;
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ValidationResponseBody {
        private String functionId;
        private String refId;
        private boolean isValid;
        private String errorCode;
        private String errorReason;
    }
}
