package com.axisbank.limit.response;

public record ResponseWrapper(Response response) {

    public static record Response(Header header, Body body) {
    }

    public static record Header(SubHeader subHeader) {
    }

    public static record SubHeader(String requestUUID, String serviceRequestId, String serviceRequestVersion,
                                   String channelId) {
    }

    public static record Body(FetchDemographicDetailsResponse fetchDemographicDetailsResponse) {
    }

    public static record FetchDemographicDetailsResponse(String encryptedResponse) {
    }

}

