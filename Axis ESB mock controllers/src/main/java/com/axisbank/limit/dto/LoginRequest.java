package com.axisbank.limit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
@ToString
public class LoginRequest {
    private Map<String, Object> metadata;
    private Payload payload;
    private String type;

    @Builder
    public static class Payload {
        @JsonProperty("oldDate1")
        private String oldDate1;
        @JsonProperty("oldDate2")
        private String oldDate2;
        @JsonProperty("newDate1")
        private String newDate1;
        @JsonProperty("newCountryCode")
        private String newCountryCode;
        @JsonProperty("oldEntityName")
        private String oldEntityName;
        @JsonProperty("oldPostalCode")
        private String oldPostalCode;
        @JsonProperty("newText")
        private String newText;
        @JsonProperty("newDate2")
        private String newDate2;
        @JsonProperty("newCharacterValue")
        private String newCharacterValue;
        @JsonProperty("customerIdFromHeader")
        private String customerIdFromHeader;
        @JsonProperty("actionCode")
        private String actionCode;
        @JsonProperty("newSurname")
        private String newSurname;
        @JsonProperty("newCustomerId")
        private String newCustomerId;
        @JsonProperty("newStateProvince")
        private String newStateProvince;
        @JsonProperty("oldCharacterValue")
        private String oldCharacterValue;
        @JsonProperty("newIndicator3")
        private String newIndicator3;
        @JsonProperty("newIndicator4")
        private String newIndicator4;
        @JsonProperty("paymentInstrumentId")
        private String paymentInstrumentId;
        @JsonProperty("newIndicator1")
        private String newIndicator1;
        @JsonProperty("newIndicator2")
        private String newIndicator2;
        @JsonProperty("userIndicator04")
        private String userIndicator04;
        @JsonProperty("userIndicator05")
        private String userIndicator05;
        @JsonProperty("oldText")
        private String oldText;
        @JsonProperty("nonmonCode")
        private String nonmonCode;
        @JsonProperty("userIndicator01")
        private String userIndicator01;
        @JsonProperty("newMiddleName")
        private String newMiddleName;
        @JsonProperty("userIndicator02")
        private String userIndicator02;
        @JsonProperty("userIndicator03")
        private String userIndicator03;
        @JsonProperty("oldId1")
        private String oldId1;
        @JsonProperty("clientIdFromHeader")
        private String clientIdFromHeader;
        @JsonProperty("serviceRepresentativeId")
        private String serviceRepresentativeId;
        @JsonProperty("contactMethodId")
        private String contactMethodId;
        @JsonProperty("recordCreationMilliseconds")
        private String recordCreationMilliseconds;
        @JsonProperty("oldId2")
        private String oldId2;
        @JsonProperty("newGivenName")
        private String newGivenName;
        @JsonProperty("oldMiddleName")
        private String oldMiddleName;
        @JsonProperty("oldStreetLine1")
        private String oldStreetLine1;
        @JsonProperty("oldStreetLine4")
        private String oldStreetLine4;
        @JsonProperty("oldStreetLine3")
        private String oldStreetLine3;
        @JsonProperty("oldStreetLine2")
        private String oldStreetLine2;
        @JsonProperty("userCode5")
        private String userCode5;
        @JsonProperty("userCode4")
        private String userCode4;
        @JsonProperty("userCode3")
        private String userCode3;
        @JsonProperty("oldGivenName")
        private String oldGivenName;
        @JsonProperty("userCode2")
        private String userCode2;
        @JsonProperty("oldNumericValue2")
        private String oldNumericValue2;
        @JsonProperty("userCode1")
        private String userCode1;
        @JsonProperty("oldNumericValue1")
        private String oldNumericValue1;
        @JsonProperty("newNumericValue1")
        private String newNumericValue1;
        @JsonProperty("newPostalCode")
        private String newPostalCode;
        @JsonProperty("newNumericValue2")
        private String newNumericValue2;
        @JsonProperty("currencyCode")
        private String currencyCode;
        @JsonProperty("oldPhone2")
        private String oldPhone2;
        @JsonProperty("oldPhone1")
        private String oldPhone1;
        @JsonProperty("oldSuffix")
        private String oldSuffix;
        @JsonProperty("transactionTime")
        private String transactionTime;
        @JsonProperty("userData01")
        private String userData01;
        @JsonProperty("userData02")
        private String userData02;
        @JsonProperty("newSuffix")
        private String newSuffix;
        @JsonProperty("userData05")
        private String userData05;
        @JsonProperty("customerAcctNumber")
        private String customerAcctNumber;
        @JsonProperty("userData06")
        private String userData06;
        @JsonProperty("userData03")
        private String userData03;
        @JsonProperty("userData04")
        private String userData04;
        @JsonProperty("pan")
        private String pan;
        @JsonProperty("userData09")
        private String userData09;
        @JsonProperty("userData07")
        private String userData07;
        @JsonProperty("contactMethod")
        private String contactMethod;
        @JsonProperty("userData08")
        private String userData08;
        @JsonProperty("oldStateProvince")
        private String oldStateProvince;
        @JsonProperty("workflow")
        private String workflow;
        @JsonProperty("newPan")
        private String newPan;
        @JsonProperty("oldEmailAddress")
        private String oldEmailAddress;
        @JsonProperty("newMonetaryValue")
        private String newMonetaryValue;
        @JsonProperty("newPaymentInstrumentId")
        private String newPaymentInstrumentId;
        @JsonProperty("decisionCode")
        private String decisionCode;
        @JsonProperty("newCode3")
        private String newCode3;
        @JsonProperty("newCode2")
        private String newCode2;
        @JsonProperty("newCode1")
        private String newCode1;
        @JsonProperty("oldCode1")
        private String oldCode1;
        @JsonProperty("oldCode2")
        private String oldCode2;
        @JsonProperty("oldCode3")
        private String oldCode3;
        @JsonProperty("userData12")
        private String userData12;
        @JsonProperty("userData13")
        private String userData13;
        @JsonProperty("userData10")
        private String userData10;
        @JsonProperty("userData11")
        private String userData11;
        @JsonProperty("userData14")
        private String userData14;
        @JsonProperty("userData15")
        private String userData15;
        @JsonProperty("oldSurname")
        private String oldSurname;
        @JsonProperty("oldCountryCode")
        private String oldCountryCode;
        @JsonProperty("newStreetLine4")
        private String newStreetLine4;
        @JsonProperty("newStreetLine3")
        private String newStreetLine3;
        @JsonProperty("newStreetLine2")
        private String newStreetLine2;
        @JsonProperty("newId2")
        private String newId2;
        @JsonProperty("newStreetLine1")
        private String newStreetLine1;
        @JsonProperty("newId1")
        private String newId1;
        @JsonProperty("reserved01")
        private String reserved01;
        @JsonProperty("newEntityName")
        private String newEntityName;
        @JsonProperty("gmtOffset")
        private String gmtOffset;
        @JsonProperty("newCustomerAcctNumber")
        private String newCustomerAcctNumber;
        @JsonProperty("recordCreationDate")
        private String recordCreationDate;
        @JsonProperty("nonmonCodeInitiator")
        private String nonmonCodeInitiator;
        @JsonProperty("newCity")
        private String newCity;
        @JsonProperty("oldIndicator1")
        private String oldIndicator1;
        @JsonProperty("dataSpecificationVersion")
        private String dataSpecificationVersion;
        @JsonProperty("oldIndicator3")
        private String oldIndicator3;
        @JsonProperty("externalTransactionId")
        private String externalTransactionId;
        @JsonProperty("oldIndicator2")
        private String oldIndicator2;
        @JsonProperty("oldIndicator4")
        private String oldIndicator4;
        @JsonProperty("newEmailAddress")
        private String newEmailAddress;
        @JsonProperty("oldMonetaryValue")
        private String oldMonetaryValue;
        @JsonProperty("recordType")
        private String recordType;
        @JsonProperty("transactionDate")
        private String transactionDate;
        @JsonProperty("recordCreationTime")
        private String recordCreationTime;
        @JsonProperty("newPhone2")
        private String newPhone2;
        @JsonProperty("oldCity")
        private String oldCity;
        @JsonProperty("newPhone1")
        private String newPhone1;
        @JsonProperty("comment")
        private String comment;
        @JsonProperty("currencyConversionRate")
        private String currencyConversionRate;
    }
}
