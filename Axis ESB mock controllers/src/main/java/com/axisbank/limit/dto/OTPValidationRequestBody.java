package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OTPValidationRequestBody {
    private ValidationRequestBody requestBody;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ValidationRequestBody{
        private String functionId;
        private String refId;
        private String otp;
    }
}
