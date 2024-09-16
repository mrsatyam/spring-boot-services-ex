package com.example.finacleservice.response.esb;

public record ESBBookFDEncResponse(
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
                CreateFDAccountResponse createFDAccountResponse
        ) {
            public record CreateFDAccountResponse(
                    String encryptedResponse
            ) {
            }
        }
    }
}
