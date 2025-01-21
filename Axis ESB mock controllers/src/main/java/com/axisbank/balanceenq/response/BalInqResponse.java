package com.axisbank.balanceenq.response;

import com.axisbank.balanceenq.response.Header;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BalInq_Response", namespace = "http://www.axisbank.com")
public class BalInqResponse {

    private Header header;
    private BalInqRspBody balInqRspBody;

    @XmlElement(name = "Header", namespace = "http://www.axisbank.com")
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    @XmlElement(name = "BalInq_Rsp_Body", namespace = "http://www.axisbank.com")
    public BalInqRspBody getBalInqRspBody() {
        return balInqRspBody;
    }

    public void setBalInqRspBody(BalInqRspBody balInqRspBody) {
        this.balInqRspBody = balInqRspBody;
    }
}
