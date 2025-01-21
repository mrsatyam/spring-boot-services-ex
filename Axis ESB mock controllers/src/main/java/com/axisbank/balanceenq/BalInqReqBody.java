package com.axisbank.balanceenq;

import jakarta.xml.bind.annotation.XmlElement;

public class BalInqReqBody {

    private String valueDt;
    private String acctCurr;
    private AcctInfo acctInfo;

    @XmlElement(name = "ValueDt", namespace = "http://www.axisbank.com")
    public String getValueDt() {
        return valueDt;
    }

    public void setValueDt(String valueDt) {
        this.valueDt = valueDt;
    }

    @XmlElement(name = "AcctCurr", namespace = "http://www.axisbank.com")
    public String getAcctCurr() {
        return acctCurr;
    }

    public void setAcctCurr(String acctCurr) {
        this.acctCurr = acctCurr;
    }

    @XmlElement(name = "AcctInfo", namespace = "http://www.axisbank.com")
    public AcctInfo getAcctInfo() {
        return acctInfo;
    }

    public void setAcctInfo(AcctInfo acctInfo) {
        this.acctInfo = acctInfo;
    }
}
