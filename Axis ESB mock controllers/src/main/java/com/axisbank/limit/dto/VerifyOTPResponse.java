package com.axisbank.limit.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyOTPResponse {
    private String traceId;
    private int returnCode;
}
