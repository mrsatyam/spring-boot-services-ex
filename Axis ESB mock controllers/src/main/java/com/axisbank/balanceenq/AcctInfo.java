package com.axisbank.balanceenq;

import jakarta.xml.bind.annotation.XmlElement;

public class AcctInfo {

    private String bankId;
    private String branchId;
    private String acctId;

    @XmlElement(name = "BankId", namespace = "http://www.axisbank.com")
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @XmlElement(name = "BranchId", namespace = "http://www.axisbank.com")
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @XmlElement(name = "AcctId", namespace = "http://www.axisbank.com")
    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }
}
