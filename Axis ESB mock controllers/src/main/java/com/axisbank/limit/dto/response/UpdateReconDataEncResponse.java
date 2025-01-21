package com.axisbank.limit.dto.response;

public record UpdateReconDataEncResponse(
    Response response
) {
    public record Response(
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
            UpdateReconDataResponse updateReconDataResponse
        ) {
            public record UpdateReconDataResponse(
                String encryptedResponse
            ) {
            }
        }
    }
}
