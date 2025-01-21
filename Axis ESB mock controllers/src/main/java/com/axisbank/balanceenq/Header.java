package com.axisbank.balanceenq;

import jakarta.xml.bind.annotation.XmlElement;

public class Header {

    private String requestUUID;
    private String serviceRequestId;
    private String serviceRequestVersion;
    private String channelId;

    @XmlElement(name = "RequestUUID", namespace = "http://www.axisbank.com")
    public String getRequestUUID() {
        return requestUUID;
    }

    public void setRequestUUID(String requestUUID) {
        this.requestUUID = requestUUID;
    }

    @XmlElement(name = "ServiceRequestId", namespace = "http://www.axisbank.com")
    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    @XmlElement(name = "ServiceRequestVersion", namespace = "http://www.axisbank.com")
    public String getServiceRequestVersion() {
        return serviceRequestVersion;
    }

    public void setServiceRequestVersion(String serviceRequestVersion) {
        this.serviceRequestVersion = serviceRequestVersion;
    }

    @XmlElement(name = "ChannelId", namespace = "http://www.axisbank.com")
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}