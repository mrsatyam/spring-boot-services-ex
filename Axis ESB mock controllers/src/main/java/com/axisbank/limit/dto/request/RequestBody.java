package com.axisbank.limit.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestBody {
    private Auth auth;
    private LogInformation logInformation;
    private Context context;
    private List<CollectionItem> collection;


    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Auth {
        private String appId;
        private String apiKey;
    }

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LogInformation {
        private String system;
        private String msgGenTime;
    }

    @Builder
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Context {
        private String templateId;
        private String senderId;
        private String priority;
    }

    @Builder
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CollectionItem {
        private Data data;
    }

    @Builder
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        private String phoneNumber;
        private Custom custom;
    }

    @Builder
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Custom {
        private String applicationId;
        private String productName;
        private String link;
        private String sourceSystemName;
        private String frequency;
        private String divisionId;
        private String channel;
        private String subDivisionId;
        private String schmType;
        private String schmCode;
        private String schmDesc;
        private String eventName;
        private String otpValidTime;
        private String intrFlag;
        private String priority;
    }
}
