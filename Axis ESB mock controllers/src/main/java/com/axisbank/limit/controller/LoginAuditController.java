package com.axisbank.limit.controller;

import com.axisbank.limit.Utility.JsonTransformer;
import com.axisbank.limit.dto.LoginRequest;
import com.axisbank.limit.dto.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/falconservice/transaction")
@Slf4j
public class LoginAuditController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> processLoginAudit(@RequestBody LoginRequest loginRequest) {
        log.info("Login audit request received... Request :{}", loginRequest);

        LoginResponse auditRes = getJsonRes();
        return new ResponseEntity<>(auditRes, HttpStatus.OK);

    }

    private LoginResponse getJsonRes() {
        String response = "{\n" +
                "  \"type\": \"Falcon:ScoringResponse:Std\",\n" +
                "  \"metadata\": {\n" +
                "    \"FAI:FALCON_RESPONSE\": \"SUCCESS\",\n" +
                "    \"FAI:FAS_RESPONSE\": {\n" +
                "      \"status\": \"SUCCESS\",\n" +
                "      \"refId\": \"XttuRisEjcQQhfGv4SBWRtYzNWrYjGZN\",\n" +
                "      \"ubaScore\": \"0\",\n" +
                "      \"riskScore\": \"800\",\n" +
                "      \"errorMessage\": \"\"\n" +
                "    },\n" +
                "    \"FalconHeaderSegment\": {\n" +
                "      \"appDataLen\": \"00001069\",\n" +
                "      \"extHdrLen\": \"0036\",\n" +
                "      \"transCode\": \"200000102\",\n" +
                "      \"source\": \"PMAX      \",\n" +
                "      \"dest\": \"tdriver   \",\n" +
                "      \"error\": \"0000000000\",\n" +
                "      \"filler\": \" \",\n" +
                "      \"enExtHdr\": \"a74f776d-4b7a-4673-b170-be4e339b7301\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"payload\": {\n" +
                "    \"responseRecordVersion\": \"4\",\n" +
                "    \"scoreCount\": \"02\",\n" +
                "    \"scoreDetails\": [\n" +
                "      {\n" +
                "        \"scoreName\": \"FAS.UBA.SCR           \",\n" +
                "        \"errorCode\": \"    \",\n" +
                "        \"score\": \"0   \",\n" +
                "        \"reason1\": \"    \",\n" +
                "        \"reason2\": \"    \",\n" +
                "        \"reason3\": \"    \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"scoreName\": \"FAS.RISK.SCR          \",\n" +
                "        \"errorCode\": \"    \",\n" +
                "        \"score\": \"700 \",\n" +
                "        \"reason1\": \"    \",\n" +
                "        \"reason2\": \"    \",\n" +
                "        \"reason3\": \"    \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"scoreName\": \"                      \",\n" +
                "        \"errorCode\": \"    \",\n" +
                "        \"score\": \"    \",\n" +
                "        \"reason1\": \"    \",\n" +
                "        \"reason2\": \"    \",\n" +
                "        \"reason3\": \"    \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"scoreName\": \"                      \",\n" +
                "        \"errorCode\": \"    \",\n" +
                "        \"score\": \"    \",\n" +
                "        \"reason1\": \"    \",\n" +
                "        \"reason2\": \"    \",\n" +
                "        \"reason3\": \"    \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"scoreName\": \"                      \",\n" +
                "        \"errorCode\": \"    \",\n" +
                "        \"score\": \"    \",\n" +
                "        \"reason1\": \"    \",\n" +
                "        \"reason2\": \"    \",\n" +
                "        \"reason3\": \"    \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"scoreName\": \"                      \",\n" +
                "        \"errorCode\": \"    \",\n" +
                "        \"score\": \"    \",\n" +
                "        \"reason1\": \"    \",\n" +
                "        \"reason2\": \"    \",\n" +
                "        \"reason3\": \"    \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"scoreName\": \"                      \",\n" +
                "        \"errorCode\": \"    \",\n" +
                "        \"score\": \"    \",\n" +
                "        \"reason1\": \"    \",\n" +
                "        \"reason2\": \"    \",\n" +
                "        \"reason3\": \"    \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"scoreName\": \"                      \",\n" +
                "        \"errorCode\": \"    \",\n" +
                "        \"score\": \"    \",\n" +
                "        \"reason1\": \"    \",\n" +
                "        \"reason2\": \"    \",\n" +
                "        \"reason3\": \"    \"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"segmentID1_3\": [\n" +
                "      {\n" +
                "        \"segmentID\": \"        \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"segmentID\": \"        \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"segmentID\": \"        \"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"filler1\": {\n" +
                "      \"filler1_1\": \"  \",\n" +
                "      \"filler1_2\": \"    \",\n" +
                "      \"filler1_3\": \"  \"\n" +
                "    },\n" +
                "    \"segmentID4_7\": [\n" +
                "      {\n" +
                "        \"segmentID\": \"        \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"segmentID\": \"        \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"segmentID\": \"        \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"segmentID\": \"        \"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"filler2\": {\n" +
                "      \"filler2_1\": \"    \",\n" +
                "      \"filler2_2\": \"    \"\n" +
                "    },\n" +
                "    \"segmentID8\": {\n" +
                "      \"segmentID\": \"        \"\n" +
                "    },\n" +
                "    \"filler3\": \"    \",\n" +
                "    \"decisionCount\": \" 0\",\n" +
                "    \"decisions1_10\": [\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"                                \",\n" +
                "        \"code\": \"                                \"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"scoringServerId\": \"    \"\n" +
                "  }\n" +
                "}";

        return JsonTransformer.transformToObject(response,LoginResponse.class);

    }
}
