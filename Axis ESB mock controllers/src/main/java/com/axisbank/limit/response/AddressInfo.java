package com.axisbank.limit.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInfo {
    private String permanentAddress1;
    private String permanentAddress2;
    private String permanentAddress3;
    private String permanentPin;
    private String permanentCity;
    private String permanentState;
    private String permanentCountry;
    private String permanentPhone1;
    private String permanentPhone2;
    private String permanentMobile;
    private String permanentFax1;
    private String permanentFax2;
    private String permanentEmailId;
    private String branch;
    private String pan;
    private String passportNo;
    private String passportIssueDate;
    private String passportDet;
    private String passportExpiryDate;
    private String visaDetails;
    private String crmRisksCore;
    private int cmgriskProfleScore;
    private String sector;
    private String companyName;
    private String tenure;
    private String workex;
    private String netIncome;
    private String department;
    private String designation;
    private String occupation;
    private String constDescription;
    private String selfEmployee;
    private LocalDateTime reKycDueDate;
}