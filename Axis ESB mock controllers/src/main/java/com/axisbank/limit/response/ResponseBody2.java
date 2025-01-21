package com.axisbank.limit.response;

public class ResponseBody2 {
    private GetAccountStatusResponse getAccountStatusResponse;

    public ResponseBody2(GetAccountStatusResponse getAccountStatusResponse) {
        this.getAccountStatusResponse = getAccountStatusResponse;
    }

    public GetAccountStatusResponse getGetAccountStatusResponse() {
        return getAccountStatusResponse;
    }

    public void setGetAccountStatusResponse(GetAccountStatusResponse getAccountStatusResponse) {
        this.getAccountStatusResponse = getAccountStatusResponse;
    }
}
