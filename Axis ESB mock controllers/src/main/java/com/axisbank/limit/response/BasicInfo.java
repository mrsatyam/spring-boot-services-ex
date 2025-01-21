package com.axisbank.limit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public final class BasicInfo {
    @JsonProperty("title")
    private final String title;
    @JsonProperty("customerFirstName")
    private final String customerFirstName;
    @JsonProperty("customerMiddleName")
    private final String customerMiddleName;
    @JsonProperty("customerLastName")
    private final String customerLastName;
    @JsonProperty("motherMaidenName")
    private final String motherMaidenName;
    @JsonProperty("dateOfBirth")
    private final String dateOfBirth;
    @JsonProperty("customerName")
    private final String customerName;
    @JsonProperty("customerSex")
    private final String customerSex;
    @JsonProperty("nationality")
    private final String nationality;
    @JsonProperty("education")
    private final String education;
    @JsonProperty("maritalStatus")
    private final String maritalStatus;
    @JsonProperty("caste")
    private final String caste;
    @JsonProperty("community")
    private final String community;
    @JsonProperty("health")
    private final String health;
    @JsonProperty("noOfDependents")
    private final String noOfDependents;
    @JsonProperty("deleteFlag")
    private final String deleteFlag;
    @JsonProperty("address")
    private final Address address;
    @JsonProperty("pin")
    private final String pin;
    @JsonProperty("city")
    private final String city;
    @JsonProperty("state")
    private final String state;
    @JsonProperty("country")
    private final String country;
    @JsonProperty("phone1")
    private final String phone1;
    @JsonProperty("phone2")
    private final String phone2;
    @JsonProperty("mobile")
    private final String mobile;
    @JsonProperty("fax1")
    private final String fax1;
    @JsonProperty("fax2")
    private final String fax2;
    @JsonProperty("emailId")
    private final String emailId;
    @JsonProperty("residentialStatus")
    private final String residentialStatus;
    @JsonProperty("cKycReferenceNumber")
    private final String cKycReferenceNumber;
    @JsonProperty("reKycDueDate")
    private final String reKycDueDate;
    @JsonProperty("constitutionDescription")
    private final String constitutionDescription;
    @JsonProperty("constitutionCode")
    private final String constitutionCode;
    @JsonProperty("annualIncome")
    private final String annualIncome;
    @JsonProperty("sourceOfIncome")
    private final String sourceOfIncome;
    @JsonProperty("occupation")
    private final String occupation;
    @JsonProperty("pan")
    private final String pan;
}
