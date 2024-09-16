package com.example.finacleservice.request;

public record ErrorResponse(
    Response response
) {
    public record Response(
        Header header,
        Error error
    ) {
        public record Header(
            SubHeader subHeader
        ) {
            public record SubHeader(
                String requestUUID,
                String serviceRequestId,
                String serviceRequestVersion,
                String channelId
            ) {
            }
        }

        public record Error(
            String errorCode,
            String message
        ) {
        }
    }
}
