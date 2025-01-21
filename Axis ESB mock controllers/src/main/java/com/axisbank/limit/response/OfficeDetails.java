package com.axisbank.limit.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDetails {
    private String officeAddress1;
    private String officeAddress2;
    private String officePin;
    private String officeCity;
    private String officeState;
    private String ext;
    private String std;
    private String officePhone1;
    private String officeMobile;
    private String officeFax1;
    private String officeEmailId;
    private String formName;
    private String companyName;
    private String selfEmpowerShip;
    private String selfEmpOther;
    private String grossTourn;
    private String cadre;
    private String customerEmployeeId;
    private String customerEmployeeNo;
    private String formNo;
    private String voterId;
    private String mop;
    private String accountId;
    private String relationshipType;
    private String schemeCode;
    private String usageFor;
    private String autoDebitOption;
    private String autoDebitAccountNo;
    private String offerId;
    private String relationAccountId;
    private String customerNreflag;
    private String reKycFlag;
    private String reKycDate;
    private int customerVintage;
    private String customerOpenDate;
    private int riskProfileScore;
    private String accountStatus;
    private String accountType;
    private String accountOpenDate;
    private String dateOfIncorporation;
    private String strUserField8;
    private String lastUnfreezeDate;
    private int balanceAmount;
    private String customerId;
    private String modeOperation;
    private String label;
    private String accountCloseDate;
    private String accountConst;
    private String rekycVintage;
    private String solId;
    private String constitutionCode;
    private String customerTypeCode;
    private String nreFlag;
    private String frezCode;
    private String frezReason;
    private String frezRemarks;
    private LocalDateTime reKycDueDate;


    // Getters and Setters
    // ...
}