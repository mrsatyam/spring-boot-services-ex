package com.axisbank.limit.dto.request;

public record UpdateReconDataEncRequest(
    Request request
) {
    public record Request(
        Header header,
        Body body
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

        public record Body(
            UpdateReconDataRequest updateReconDataRequest
        ) {
            public record UpdateReconDataRequest(
                String encryptedRequest
            ) {
            }
        }
    }
}
