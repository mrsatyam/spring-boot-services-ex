package com.axisbank.limit.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserValidationRequest {
    private String username;
    private String password;

}
