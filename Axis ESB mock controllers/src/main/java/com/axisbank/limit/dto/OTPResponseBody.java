package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OTPResponseBody {
    private ResponseBody responseBody;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseBody {
        private String acknowledgementId;
        private String errorDescription;
        private String errorCode;
        private String status;
    }
}
