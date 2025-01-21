package com.axisbank.limit.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendSmsResponse {
    @JsonProperty("response")
    private Response response;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {

        @JsonProperty("header")
        private Header header;

        @JsonProperty("body")
        private Body body;

        @JsonProperty("error")
        private ErrorResponse error;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Header {

        @JsonProperty("subHeader")
        private SubHeader subHeader;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SubHeader {

        @JsonProperty("requestUUID")
        private String requestUUID;

        @JsonProperty("serviceRequestId")
        private String serviceRequestId;

        @JsonProperty("serviceRequestVersion")
        private String serviceRequestVersion;

        @JsonProperty("channelId")
        private String channelId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Body {

        @JsonProperty("sendMessageResponse")
        private SendMessageResponse sendMessageResponse;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SendMessageResponse {

        @JsonProperty("encryptedResponse")
        private String encryptedResponse;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ErrorResponse {

        @JsonProperty("errorCode")
        private String errorCode;

        @JsonProperty("message")
        private String message;
    }
}