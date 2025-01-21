package com.axisbank.limit.request;

public record AccountStatusRequestWrapper(Request request) {

    public static record Request(Header header, Body body) {
    }

    public static record Header(SubHeader subHeader) {
    }

    public static record SubHeader(
            String requestUUID,
            String serviceRequestId,
            String serviceRequestVersion,
            String channelId
    ) {
    }

    public static record Body(GetAccountStatusRequest getAccountStatusRequest) {
    }

    public static record GetAccountStatusRequest(String encryptedRequest) {
    }

}

