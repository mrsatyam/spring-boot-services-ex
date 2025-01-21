package com.axisbank.limit.response;

public class EncryptedAccountStatusResponse {
    private String encryptedResponse;

    public EncryptedAccountStatusResponse(String encryptedResponse) {
        this.encryptedResponse = encryptedResponse;
    }

    public String getEncryptedResponse() {
        return encryptedResponse;
    }

    public void setEncryptedResponse(String encryptedResponse) {
        this.encryptedResponse = encryptedResponse;
    }
}
