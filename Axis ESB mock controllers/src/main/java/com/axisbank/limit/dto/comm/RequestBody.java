package com.axisbank.limit.dto.comm;
public class RequestBody {
    private String aumChannelIdentifier;
    private String customerId;

    public String getAumChannelIdentifier() {
        return aumChannelIdentifier;
    }

    public void setAumChannelIdentifier(String aumChannelIdentifier) {
        this.aumChannelIdentifier = aumChannelIdentifier;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
