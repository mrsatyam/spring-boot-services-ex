package com.example.finacleservice.controller;

import com.example.finacleservice.enc.AES128;
import com.example.finacleservice.request.CreateFdRequestBody;
import com.example.finacleservice.request.ESBBookFDEncRequest;
import com.example.finacleservice.request.ErrorResponse;
import com.example.finacleservice.response.esb.CreateFdResponseBody;
import com.example.finacleservice.response.esb.ESBBookFDEncResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@RequestMapping("api/v1")
public class GCFDCreateController {

    @PostMapping("/create-fd-account")
    public ResponseEntity<Object> createFd(@RequestBody ESBBookFDEncRequest request) throws JsonProcessingException {
        var req = request;
        var encReq = request.request().body().createFDAccountRequest().encryptedRequest();
        log.info("Req recvd: " + encReq);
        var decr = AES128.decrypt(encReq, "IBB741345368e9c11e9ae4b0a0950d80000");
        CreateFdRequestBody createFdRequestBody = new ObjectMapper().registerModule(new JavaTimeModule())
                .readValue(decr, CreateFdRequestBody.class);
        System.out.println(createFdRequestBody);
        var resp = createDummyResponse();
//        return ResponseEntity.ok(resp);
        return ResponseEntity.badRequest().body(createDummyErrorResponse());
    }

    public static CreateFdResponseBody createDummyResponseBody() {
        return new CreateFdResponseBody(
                new CreateFdResponseBody.ResponseBody(
                        "924040056138343",                  // accountId
                        "SC001",                            // schemeCode
                        "FixedDeposit",                     // schemeType
                        "INR",                              // currency
                        new CreateFdResponseBody.ResponseBody.BankInformation(
                                "BANK001",                   // bankId
                                "Axis Bank",                 // name
                                "BR001",                     // branchId
                                "Main Branch",               // branchName
                                new CreateFdResponseBody.ResponseBody.BankInformation.PostalAddress(
                                        "123 Main St",       // address1
                                        "Suite 100",         // address2
                                        "Business District", // address3
                                        "Mumbai",            // city
                                        "Maharashtra",       // state
                                        "400001",            // postalCode
                                        "India",             // country
                                        "Business"           // addressType
                                )
                        ),
                        "API-BIOFD-ETB-BBFD20230516100129"  // ntdNumber
                )
        );
    }

    public static ESBBookFDEncResponse createDummyResponse() {
        var plainRespBody = createDummyResponseBody();
        ObjectMapper objectMapper = new ObjectMapper();
        String plainRespStr;
        try {
             plainRespStr = objectMapper.writeValueAsString(plainRespBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new ESBBookFDEncResponse(
                new ESBBookFDEncResponse.Response(
                        new ESBBookFDEncResponse.Response.Header(
                                new ESBBookFDEncResponse.Response.Header.SubHeader(
                                        "1234567890",             // requestUUID
                                        "AE.OBP.FIN.SSTP.001",    // serviceRequestId
                                        "1.0",                    // serviceRequestVersion
                                        "ESB"                     // channelId
                                )
                        ),
                        new ESBBookFDEncResponse.Response.Body(
                                new ESBBookFDEncResponse.Response.Body.CreateFDAccountResponse(
                                        AES128.encrypt(plainRespStr, "IBB741345368e9c11e9ae4b0a0950d80000")  // encryptedResponse
                                )
                        )
                )
        );
    }

    public static ErrorResponse createDummyErrorResponse() {
        return new ErrorResponse(
                new ErrorResponse.Response(
                        new ErrorResponse.Response.Header(
                                new ErrorResponse.Response.Header.SubHeader(
                                        "474893373",                     // requestUUID
                                        "AE.OBP.FIN.SSTP.001",           // serviceRequestId
                                        "1.0",                           // serviceRequestVersion
                                        "ESB"                            // channelId
                                )
                        ),
                        new ErrorResponse.Response.Error(
                                "067",                              // errorCode
                                "The scheme code is invalid./acctCrit.schmCode.schmCode"  // message
                        )
                )
        );
    }
}
