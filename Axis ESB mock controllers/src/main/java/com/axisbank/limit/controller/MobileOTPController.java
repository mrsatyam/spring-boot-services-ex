package com.axisbank.limit.controller;

import com.axisbank.limit.Utility.JsonTransformer;
import com.axisbank.limit.dto.*;
import com.axisbank.limit.encryption.ESBAES128Encryption;
import io.swagger.v3.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chub-otp/enc")
@Slf4j
public class MobileOTPController {

    public static final String ENCRYPTION_PASSWORD = "OAUTH011efd5c000856011ef0b93400a0904e900";

    @PostMapping("/validate-otp")
    public ResponseEntity<OTPValidationResponse> validateOTP(@RequestBody OTPValidationRequest request){
        log.info("OTP validation request received..."+ request);
        log.info("OTP validation Request Json : {}", Json.pretty(request));
        OTPValidationResponse response =null;
        String decryptedBody = ESBAES128Encryption.decrypt(request.getRequest().getBody().getValidateOTPRequest().getEncryptedRequest(), ENCRYPTION_PASSWORD);
        log.info("Body :{}",decryptedBody);
        OTPValidationRequestBody requestBody = JsonTransformer.transformToObject(decryptedBody,OTPValidationRequestBody.class);

        if (StringUtils.isNotBlank(requestBody.getRequestBody().getOtp())&& StringUtils.isNotBlank(requestBody.getRequestBody().getRefId()) && "123456".equalsIgnoreCase(requestBody.getRequestBody().getOtp())) {
            response = prepareOTPSuccessResponse(request,requestBody);
        } else {
            response = prepareOTPErrorResponse(request,requestBody);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    private OTPValidationResponse prepareOTPErrorResponse(OTPValidationRequest request, OTPValidationRequestBody requestBody) {

        OTPValidationResponse failedResponse = OTPValidationResponse.builder()
                .response(buildValidationResponse(request, requestBody))
                .build();
        OTPValidationResponseBody responseBody = OTPValidationResponseBody.builder()
                .responseBody(buildValidationRespBody(requestBody))
                .build();
        responseBody.getResponseBody().setErrorCode("err-002");
        responseBody.getResponseBody().setErrorReason("Your OTP seems to have expired");
        responseBody.getResponseBody().setValid(false);
        String encryptedText = ESBAES128Encryption.encrypt(JsonTransformer.transformToJson(responseBody),ENCRYPTION_PASSWORD);
        failedResponse.getResponse().getBody().getValidateOTPResponse()
                .setEncryptedResponse(encryptedText);
        return failedResponse;

    }

    private OTPValidationResponse.Response buildValidationResponse(OTPValidationRequest request, OTPValidationRequestBody requestBody) {
        return OTPValidationResponse.Response.builder()
                .header(buildValidationHeader(request))
                .body(buildValidationBody(requestBody))
                .build();
    }

    private OTPValidationResponse.Body buildValidationBody(OTPValidationRequestBody requestBody) {
        return new OTPValidationResponse.Body(buildValidationBodyData(requestBody));
    }

    private OTPValidationResponse.ValidateOTPResponse buildValidationBodyData(OTPValidationRequestBody requestBody) {
        return new OTPValidationResponse.ValidateOTPResponse(buildValidationEncryptedResponse(requestBody));
    }

    private String buildValidationEncryptedResponse(OTPValidationRequestBody requestBody) {
        OTPValidationResponseBody responseBody = OTPValidationResponseBody.builder()
                .responseBody(buildValidationRespBody(requestBody))
                .build();
        System.out.println("Response body :"+JsonTransformer.transformToJson(responseBody));
        return ESBAES128Encryption.encrypt(JsonTransformer.transformToJson(responseBody),ENCRYPTION_PASSWORD);
    }

    private OTPValidationResponseBody.ValidationResponseBody buildValidationRespBody(OTPValidationRequestBody requestBody) {
        return OTPValidationResponseBody.ValidationResponseBody.builder()
                .isValid(true)
                .refId(requestBody.getRequestBody().getRefId())
                .functionId(requestBody.getRequestBody().getFunctionId())
                .build();
    }

    private Header buildValidationHeader(OTPValidationRequest request) {
        return new Header(buildValidationSubHeader(request));
    }

    private Header.SubHeader buildValidationSubHeader(OTPValidationRequest request) {
        return Header.SubHeader.builder()
                .channelId(request.getRequest().getHeader().getSubHeader().getChannelId())
                .requestUUID(request.getRequest().getHeader().getSubHeader().getRequestUUID())
                .serviceRequestId(request.getRequest().getHeader().getSubHeader().getServiceRequestId())
                .serviceRequestVersion(request.getRequest().getHeader().getSubHeader().getServiceRequestVersion())
                .build();
    }

    @PostMapping("/generate-otp")
    public ResponseEntity<OTPGenResponse> generateOTP(@RequestBody OTPGenRequest request){
        log.info("Generate opt request received : "+Json.pretty(request));
        log.info("Generate OTP  Request Json : {}", Json.pretty(ESBAES128Encryption.decrypt(request.getRequest().getBody().getGenerateOTPRequest().getEncryptedRequest(),ENCRYPTION_PASSWORD)));

        OTPGenResponse response = OTPGenResponse.builder()
                .response(getOTPGenResponse(request))
                .build();

        log.info("Response Json : {}", Json.pretty(response));

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    private OTPGenResponse.Response getOTPGenResponse(OTPGenRequest request) {
        return OTPGenResponse.Response.builder().header(request.getRequest().getHeader())
                .body(buildBody())
                .build();
    }

    private OTPGenResponse.Body buildBody() {
        return new OTPGenResponse.Body(buildBodyData());
    }

    private OTPGenResponse.GenerateOTPResponse buildBodyData() {
        return new OTPGenResponse.GenerateOTPResponse(buildEncryptedResponse());
    }

    private String buildEncryptedResponse() {
        OTPResponseBody responseBody = new OTPResponseBody(buildResponseBody());
        String responseBodyStr = JsonTransformer.transformToJson(responseBody);
        return ESBAES128Encryption.encrypt(responseBodyStr, ENCRYPTION_PASSWORD);
    }

    private OTPResponseBody.ResponseBody buildResponseBody() {
        return OTPResponseBody.ResponseBody.builder()
                .acknowledgementId("6952645017277483000")
                .status("ACCEPT")
                .errorCode("0")
                .errorDescription("")
                .build();
    }

    private OTPValidationResponse prepareOTPSuccessResponse(OTPValidationRequest request, OTPValidationRequestBody requestBody) {
        return OTPValidationResponse.builder()
                .response(buildValidationResponse(request, requestBody))
                .build();
    }
}
