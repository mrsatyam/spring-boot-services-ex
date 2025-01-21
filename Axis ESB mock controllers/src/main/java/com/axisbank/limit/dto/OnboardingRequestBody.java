package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OnboardingRequestBody {
    private RequestBody requestBody;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class RequestBody{
        private String channelCode;
        private String searchBy;
        private String searchValue;
    }

}
