package com.axisbank.balanceenq.response;

import jakarta.xml.bind.annotation.XmlElement;

import java.math.BigDecimal;

public class BalAmt {

    private BigDecimal amountValue;
    private String currencyCode;

    @XmlElement(name = "amountValue", namespace = "http://www.axisbank.com")
    public BigDecimal getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(BigDecimal amountValue) {
        this.amountValue = amountValue;
    }

    @XmlElement(name = "currencyCode", namespace = "http://www.axisbank.com")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
