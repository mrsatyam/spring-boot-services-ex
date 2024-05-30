package com.example.finacleservice.response;

public record CloseFDRDResponse(Response response) {
    public record Response(Header header, Body body) {
    }
    public record SubHeader(
            String requestUUID,
            String serviceRequestId,
            String serviceRequestVersion,
            String channelId
    ) {
    }

    public record Header(
            SubHeader subHeader
    ) {
    }

    public record CloseResponse(
            String encryptedResponse
    ) {
    }

    public record Body(
            CloseResponse closeResponse
    ) {
    }
}
