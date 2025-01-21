package com.axisbank.limit.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageRequest {
    private Request request;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private Header header;
        private Body body;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Header {
            private SubHeader subHeader;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class SubHeader {
                private String requestUUID;
                private String serviceRequestId;
                private String serviceRequestVersion;
                private String channelId;
            }
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Body {
            private SendMessageRequestDetails sendMessageRequest;
            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class SendMessageRequestDetails {
                private String encryptedRequest;
            }
        }
    }
}
//https://confluence.axisb.com/display/ESB/sendMessage
