package com.axisbank.limit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private String type;
    private Metadata metadata;
    private Payload payload;

    @Data
    public static class Metadata {
        @JsonProperty("FAI:FALCON_RESPONSE")
        private String falconResponse;
        @JsonProperty("FAI:FAS_RESPONSE")
        private FASResponse fasResponse;
        @JsonProperty("FalconHeaderSegment")
        private FalconHeaderSegment falconHeaderSegment;

        @Data
        public static class FASResponse {
            private String status;
            private String refId;
            private String ubaScore;
            private String riskScore;
            private String errorMessage;

        }
        
        @Data
        public static class FalconHeaderSegment {
            private String appDataLen;
            private String extHdrLen;
            private String transCode;
            private String source;
            private String dest;
            private String error;
            private String filler;
            private String enExtHdr;
            
        }
    }

    @Data
    public static class Payload {
        private String responseRecordVersion;
        private String scoreCount;
        private List<ScoreDetail> scoreDetails;
        private List<SegmentID> segmentID1_3;
        private Filler1 filler1;
        private List<SegmentID> segmentID4_7;
        private Filler2 filler2;
        private SegmentID segmentID8;
        private String filler3;
        private String decisionCount;
        private List<Decision> decisions1_10;
        private String scoringServerId;

        @Data
        public static class ScoreDetail {
            private String scoreName;
            private String errorCode;
            private String score;
            private String reason1;
            private String reason2;
            private String reason3;
        }

        @Data
        public static class SegmentID {
            private String segmentID;
        }

        @Data
        public static class Filler1 {
            @JsonProperty("filler1_1")
            private String filler1_1;
            @JsonProperty("filler1_2")
            private String filler1_2;
            @JsonProperty("filler1_3")
            private String filler1_3;
        }

        @Data
        public static class Filler2 {
            @JsonProperty("filler2_1")
            private String filler2_1;
            @JsonProperty("filler2_2")
            private String filler2_2;

        }
        @Data
        public static class Decision {
            private String type;
            private String code;
        }
    }
}
