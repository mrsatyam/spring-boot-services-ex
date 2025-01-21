package com.axisbank.limit.controller;

import com.axisbank.limit.Utility.JsonTransformer;
import com.axisbank.limit.dto.ChubOtpResponse;
import com.axisbank.limit.dto.RequestMessage;
import com.axisbank.limit.dto.request.SendMessageRequest;
import com.axisbank.limit.dto.response.ResponseBody;
import com.axisbank.limit.dto.response.SendSmsResponse;
import com.axisbank.limit.encryption.ESBAES128Encryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.axisbank.limit.controller.MobileOTPController.ENCRYPTION_PASSWORD;

@RestController
@RequestMapping("/chub-sms/enc")
@Slf4j
public class InvalidOTPCommunicationController {

    @PostMapping("/send-message")
    public ResponseEntity<SendSmsResponse> sendOTP(SendMessageRequest request){
        log.info("Incorrect OTP request : {}", JsonTransformer.transformToJson(request));
        return new ResponseEntity<>(getResponse(), HttpStatus.OK);

    }

    private SendSmsResponse getResponse() {
        return SendSmsResponse.builder()
                .response(getResponseObj())
                .build();
    }

    private SendSmsResponse.Response getResponseObj() {
        return SendSmsResponse.Response.builder()
                .body(getResBodyObj())
                .build();
    }

    private SendSmsResponse.Body getResBodyObj() {
        return SendSmsResponse.Body.builder()
                .sendMessageResponse(getSendMessageRes())
                .build();
    }

    private SendSmsResponse.SendMessageResponse getSendMessageRes() {
        return SendSmsResponse.SendMessageResponse.builder()
                .encryptedResponse(getEncryptedResp())
                .build();
    }

    private String getEncryptedResp() {
        ResponseBody responseBody = ResponseBody.builder()
                .acknowledgementId(6241849172954133314L)
                .chubTransId("601234")
                .status("ACCEPT")
                .build();
        return ESBAES128Encryption.encrypt(JsonTransformer.transformToJson(responseBody), ENCRYPTION_PASSWORD);
    }
}
