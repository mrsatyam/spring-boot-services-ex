package com.example.finacleservice.response;

public record CloseFDRDResponsePlain(
        ResponseBody responseBody) {
    public record ResponseBody(String flag,
                               String flagDate,
                               String successOrFailure,
                               String normalInterestPercentage,
                               String effectiveInterestPercentage,
                               String normalInterestAmount,
                               String actualInterestAmount,
                               String penalInterestAmount,
                               String penalInterestPercentage,
                               String totalPenal,
                               String accountId,
                               String interestRecovery,
                               String closeValueDate,
                               String depositAmount,
                               String interestTaken,
                               String withdrawlAmount,
                               String lienAmount) {

    }
}
