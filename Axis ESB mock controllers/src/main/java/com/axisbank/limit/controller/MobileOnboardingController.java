package com.axisbank.limit.controller;

import com.axisbank.limit.Utility.JsonTransformer;
import com.axisbank.limit.dto.*;
import com.axisbank.limit.encryption.ESBAES128Encryption;
import io.swagger.v3.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

import static com.axisbank.limit.controller.MobileOTPController.ENCRYPTION_PASSWORD;

@RestController
@RequestMapping("/aum/cust/onboardingdedupe/enc")
@Slf4j
public class MobileOnboardingController {

    @PostMapping("/fetch-customer-relationship")
    public ResponseEntity<MobileOnboardingResponse> validateMobileNumberAndFetchDetails(@RequestBody MobileOnboardingRequest request){
        log.info("Mobile onboarding request received :{}", Json.pretty(request));
        String decryptedBody = ESBAES128Encryption.decrypt(request.getRequest().getBody().getFetchCustomerRelationshipRequest().getEncryptedRequest(), ENCRYPTION_PASSWORD);
        log.info("Mobile request Body :{}",decryptedBody);
        OnboardingRequestBody requestBody = JsonTransformer.transformToObject(decryptedBody,OnboardingRequestBody.class);
        MobileOnboardingResponse response=null;
        if("AXMOBILE".equalsIgnoreCase(requestBody.getRequestBody().getChannelCode()) && "919654401102".equalsIgnoreCase(requestBody.getRequestBody().getSearchValue())) {
            response = buildMobileOnboardingResponse(requestBody, request);
            
        } else {
            response = buildMobileOnboardingFailedResponse( request);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private MobileOnboardingResponse buildMobileOnboardingFailedResponse( MobileOnboardingRequest request) {
        return new  MobileOnboardingResponse(buildErrorResponse(request));
    }

    private MobileOnboardingResponse.Response buildErrorResponse( MobileOnboardingRequest request) {
        return MobileOnboardingResponse.Response.builder()
                .header(request.getRequest().getHeader())
                .error(buildErrorRes())
                .build();
    }

    private MobileOnboardingResponse.Error buildErrorRes() {
        return new MobileOnboardingResponse.Error("821","Invalid format");
    }


    private MobileOnboardingResponse buildMobileOnboardingResponse(OnboardingRequestBody requestBody, MobileOnboardingRequest request) {
        return new  MobileOnboardingResponse(buildResponse(requestBody,request));
    }

    private MobileOnboardingResponse.Response buildResponse(OnboardingRequestBody requestBody, MobileOnboardingRequest request) {
        return MobileOnboardingResponse.Response.builder()
                .header(request.getRequest().getHeader())
                .body(buildBody(requestBody))
                .build();
    }

    private MobileOnboardingResponse.Body buildBody(OnboardingRequestBody requestBody) {
        return new MobileOnboardingResponse.Body(buildBodyData(requestBody));
    }

    private MobileOnboardingResponse.FetchCustomerRelationshipResponse buildBodyData(OnboardingRequestBody requestBody) {
        return new MobileOnboardingResponse.FetchCustomerRelationshipResponse(buildCustomerData(requestBody));
    }

    private String buildCustomerData(OnboardingRequestBody requestBody) {
        OnboardingResponseBody responseBody = new OnboardingResponseBody(buildResponseBodyData(requestBody));
        String responseBodyJson = JsonTransformer.transformToJson(responseBody);
        log.info("REsponse body json :{}",responseBodyJson);
        return ESBAES128Encryption.encrypt(responseBodyJson,ENCRYPTION_PASSWORD);
    }

    private OnboardingResponseBody.ResponseBody buildResponseBodyData(OnboardingRequestBody requestBody) {
        return OnboardingResponseBody.ResponseBody.builder()
                .lastModifiedOn(Instant.now().toString())
                .nriFlag("N")
                .customerIdentifier("EXISTING-CASA")
                .primaryProd("SMSREG")
                .chanCode(buildChannelCode(requestBody))
                .build();
    }

    private List<ChanCode> buildChannelCode(OnboardingRequestBody requestBody) {
        return List.of(buildChanCodeData(requestBody,"SMSREG","658000812","999199346640259","axis-test@axis.com"),
                buildChanCodeData(requestBody,"DEBITCARD","658000812","4575809200085356","axis-test@axis.com"));
    }

    private ChanCode buildChanCodeData(OnboardingRequestBody requestBody,String prodCode,String customerId,String prodValue,String emailId) {
        return ChanCode.builder()
                .channelCode(requestBody.getRequestBody().getChannelCode())
                .mobileNumber(requestBody.getRequestBody().getSearchValue())
                .prodCode(prodCode)
                .customerId(customerId)
                .prodValue(prodValue)
                .emailId(emailId)
                .build();
    }

}
