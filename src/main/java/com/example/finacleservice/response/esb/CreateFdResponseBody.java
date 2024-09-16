package com.example.finacleservice.response.esb;

public record CreateFdResponseBody(ResponseBody responseBody) {
    public record ResponseBody(
            String accountId,
            String schemeCode,
            String schemeType,
            String currency,
            BankInformation bankInformation,
            String ntdNumber
    ) {
        public record BankInformation(
                String bankId,
                String name,
                String branchId,
                String branchName,
                PostalAddress postalAddress
        ) {
            public record PostalAddress(
                    String address1,
                    String address2,
                    String address3,
                    String city,
                    String state,
                    String postalCode,
                    String country,
                    String addressType
            ) {
            }
        }
    }
}
