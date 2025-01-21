package com.axisbank.balanceenq.response;

import jakarta.xml.bind.annotation.XmlElement;

public class AcctBal {

    private String balType;
    private BalAmt balAmt;

    @XmlElement(name = "BalType", namespace = "http://www.axisbank.com")
    public String getBalType() {
        return balType;
    }

    public void setBalType(String balType) {
        this.balType = balType;
    }

    @XmlElement(name = "BalAmt", namespace = "http://www.axisbank.com")
    public BalAmt getBalAmt() {
        return balAmt;
    }

    public void setBalAmt(BalAmt balAmt) {
        this.balAmt = balAmt;
    }
}
