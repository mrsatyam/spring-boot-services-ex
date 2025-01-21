package com.axisbank.limit.dto.comm;
public class FetchCommunicationDetailsRequest {
    private String encryptedRequest;

    public String getEncryptedRequest() {
        return encryptedRequest;
    }

    public void setEncryptedRequest(String encryptedRequest) {
        this.encryptedRequest = encryptedRequest;
    }
}
