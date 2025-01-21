package com.axisbank.limit.request;

import jakarta.validation.constraints.NotBlank;

public record RequestBody(
        @NotBlank(message = "customerId must not be blank")
        String customerId,
        @NotBlank(message = "accountId must not be blank")
        String accountId
) {
}

