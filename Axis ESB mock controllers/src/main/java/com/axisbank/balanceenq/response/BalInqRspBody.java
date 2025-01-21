package com.axisbank.balanceenq.response;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class BalInqRspBody {

    private String valueDt;
    private String acctCurr;
    private String status;
    private List<AcctBal> acctBals;

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

    @XmlElement(name = "Status", namespace = "http://www.axisbank.com")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name = "AcctBal", namespace = "http://www.axisbank.com")
    public List<AcctBal> getAcctBals() {
        return acctBals;
    }

    public void setAcctBals(List<AcctBal> acctBals) {
        this.acctBals = acctBals;
    }
}
