package com.axisbank.balanceenq;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BalInq_Request", namespace = "http://www.axisbank.com")
public class BalInqRequest {

    private Header header;
    private BalInqReqBody balInqReqBody;

    @XmlElement(name = "Header", namespace = "http://www.axisbank.com")
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    @XmlElement(name = "BalInq_Req_Body", namespace = "http://www.axisbank.com")
    public BalInqReqBody getBalInqReqBody() {
        return balInqReqBody;
    }

    public void setBalInqReqBody(BalInqReqBody balInqReqBody) {
        this.balInqReqBody = balInqReqBody;
    }
}