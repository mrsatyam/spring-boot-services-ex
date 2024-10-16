package com.example.finacleservice.request;

import java.time.LocalDate;

public record NomineeDetails(
            String regNumber,
            String nomineeName,
            String relType,
            NomineeContactDetails nomineeContactDetails,
            String nomineeMinorFlag,
            String nomineeBirthDate,
            String nomineePercentValue,
            GuardianDetails guardianDetails
    ) {

        public record NomineeContactDetails(
                PhoneNumberDetails phoneNumberDetails,
                String email,
                PostalAddress postalAddress
        ) {
            public record PhoneNumberDetails(
                    String telephone,
                    String fax,
                    String telex
            ) {}

            public record PostalAddress(
                    String addressLine1,
                    String addressLine2,
                    String addressLine3,
                    String city,
                    String state,
                    String postalCode,
                    String country,
                    String addressType
            ) {}
        }

        public record GuardianDetails(
                String guardianCode,
                String guardianName,
                GuardianContactDetails guardianContactDetails
        ) {
            public record GuardianContactDetails(
                    PhoneNumberDetails phoneNumberDetails,
                    String email,
                    PostalAddress postalAddress
            ) {
                public record PhoneNumberDetails(
                        String telephone,
                        String fax,
                        String telex
                ) {}

                public record PostalAddress(
                        String addressLine1,
                        String addressLine2,
                        String addressLine3,
                        String city,
                        String state,
                        String postalCode,
                        String country,
                        String addressType
                ) {}
            }
        }
    }