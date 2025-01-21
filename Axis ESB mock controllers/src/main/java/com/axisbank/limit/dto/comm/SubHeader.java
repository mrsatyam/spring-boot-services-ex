package com.axisbank.limit.dto.comm;
public class SubHeader {
    private String serviceRequestVersion;
    private String serviceRequestId;
    private String requestUUID;
    private String channelId;

    public String getServiceRequestVersion() {
        return serviceRequestVersion;
    }

    public void setServiceRequestVersion(String serviceRequestVersion) {
        this.serviceRequestVersion = serviceRequestVersion;
    }

    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getRequestUUID() {
        return requestUUID;
    }

    public void setRequestUUID(String requestUUID) {
        this.requestUUID = requestUUID;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}