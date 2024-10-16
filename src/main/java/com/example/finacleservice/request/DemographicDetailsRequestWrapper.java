package com.example.finacleservice.request;

public record DemographicDetailsRequestWrapper(Request request) {

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

    public static record Body(DemographicDetailsRequest fetchDemographicDetailsRequest) {
    }

    public static record DemographicDetailsRequest(String encryptedRequest) {
    }

}

