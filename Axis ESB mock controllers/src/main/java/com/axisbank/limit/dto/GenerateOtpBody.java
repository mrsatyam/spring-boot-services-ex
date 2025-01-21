package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenerateOtpBody {
    private RequestBody requestBody;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RequestBody {
        private Auth auth;
        private LogInformation logInformation;
        private Context context;
        private Data data;

    }
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

    @lombok.Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Context {
        private String templateId;
        private String priority;
        private String senderId;
    }

    @lombok.Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        private String toEmailId;
        private String ccEmailId;
        private String bccEmailId;
        private String phoneNumber;
        private String altPhoneNumber;
        private String altEmail;
        private String subject;
        private String smsg;
        private String otpLength;
        private String otpValidityPeriod;
        private String functionId;
        private String refId;
        private List<Statement> statements;
        private Custom custom;
    }
    @lombok.Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
        public static class Statement {
            private String txnDate;
            private String txnRemarks;
            private String amount;
            private String balanceAmount;
        }

    @lombok.Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
        public static class Custom {
            private String channel;
            private String sourceSystemName;
            private String priority;
            private String frequency;
            private String divisionId;
            private String subDivisionId;
            private String intrFlag;
            private String eventName;
            private String url;
            private String reason1;
            private String reason2;
            private String reason3;
            private String cardNo;
            private String srNo;
            private String typeName;
            private String custFirstName;
            private String custLastName;
            private String amt;
            private String accountId;
            private String date;
            private String lastBillAmt;
            private String lastDueAmt;
            private String minDueAmt;
            private String overdueAmt;
            private String amount;
            private String creditNo;
            private String dueDate;
            private String customerName;
            private String free_text_1;
            private String free_text_2;
            private String free_text_3;
            private String free_text_4;
            private String free_text_5;
            private String free_text_6;
            private String free_text_7;
            private String free_text_8;
            private String free_text_9;
            private String free_text_10;
            private String free_text_11;
            private String free_text_12;
            private String free_text_13;
            private String free_text_14;
            private String free_text_15;
            private String free_text_16;
            private String free_text_17;
            private String free_text_18;
            private String free_text_19;
            private String free_text_20;
            private String free_text_21;
            private String free_text_22;
            private String free_text_23;
            private String free_text_24;
            private String free_text_25;
            private String schmType;
            private String schmCode;
            private String schmDesc;
        }
    }


