package com.axisbank.limit.dto;

import lombok.Data;

@Data
public class UserValidationResponse {
    private String message;
    private String token;
    private String status;
}
