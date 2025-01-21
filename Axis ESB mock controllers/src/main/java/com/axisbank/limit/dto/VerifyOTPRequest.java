package com.axisbank.limit.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyOTPRequest {
    private String actionBy;
    private String samlId;
    private String userId;
    private int otp;
}
