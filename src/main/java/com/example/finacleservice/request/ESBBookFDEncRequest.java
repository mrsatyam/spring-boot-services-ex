package com.example.finacleservice.request;

public record ESBBookFDEncRequest(
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
                CreateFDAccountRequest createFDAccountRequest
        ) {
            public record CreateFDAccountRequest(
                    String encryptedRequest
            ) {

            }
        }
    }

    public static class Builder {
        private Request.Header.SubHeader subHeader;
        private String encryptedRequest;

        public static Builder builder() {
            return new Builder();
        }


        public Builder subHeader(Request.Header.SubHeader subHeader) {
            this.subHeader = subHeader;
            return this;
        }

        public Builder encryptedRequest(String encryptedRequest) {
            this.encryptedRequest = encryptedRequest;
            return this;
        }

        public ESBBookFDEncRequest build() {
            Request.Header header = new Request.Header(subHeader);
            Request.Body body = new Request.Body(new Request.Body.CreateFDAccountRequest(encryptedRequest));
            return new ESBBookFDEncRequest(new Request(header, body));
        }
    }


}
