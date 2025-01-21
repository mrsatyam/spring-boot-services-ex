package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnboardingResponseBody {
    private ResponseBody responseBody;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResponseBody {
        private String primaryProd;
        private String nriFlag;
        private String customerIdentifier;
        private String lastModifiedOn;
        private List<ChanCode> chanCode;
    }

}
