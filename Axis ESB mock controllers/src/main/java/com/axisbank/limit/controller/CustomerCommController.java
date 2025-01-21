package com.axisbank.limit.controller;

import com.axisbank.limit.Utility.JsonTransformer;
import com.axisbank.limit.dto.comm.CustomerCommunicationRequest;
import com.axisbank.limit.dto.comm.RequestBodyWrapper;
import com.axisbank.limit.dto.comm.response.*;
import com.axisbank.limit.dto.comm.response.ResponseBody;
import com.axisbank.limit.encryption.ESBAES128Encryption;
import com.axisbank.limit.encryption.ESBEncDec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aum/mobileemail/detais/enc")
@Slf4j
public class CustomerCommController {
    String key="IBB741345368e9c11e9ae4b0a0950d80000";

    @PostMapping("/fetch-communication-details")
    public ResponseEntity<CustomerCommunicationResponse> fetchCustCommunicationDetails(@RequestBody CustomerCommunicationRequest request) throws Exception {

        log.info("Cust comm request :{}", JsonTransformer.transformToJson(request));
        String bodyWrapperJson = ESBEncDec.decrypt(request.getRequest().getBody().getFetchCommunicationDetailsRequest().getEncryptedRequest(), key);
        log.info("BodyReq: {}", bodyWrapperJson);
        RequestBodyWrapper bodyWrapper = JsonTransformer.transformToObject(bodyWrapperJson, RequestBodyWrapper.class);
        CustomerCommunicationResponse response =buildCustCommResp(bodyWrapper, request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    private CustomerCommunicationResponse buildCustCommResp(RequestBodyWrapper bodyWrapper, CustomerCommunicationRequest request) throws Exception {
        CustomerCommunicationResponse response = new CustomerCommunicationResponse();
        Response resp= new Response();
        resp.setHeader(request.getRequest().getHeader());
        com.axisbank.limit.dto.comm.response.Body body = new Body();
        body.setFetchCommunicationDetailsResponse(buildCommDetails(bodyWrapper));
        resp.setBody(body);
        response.setResponse(resp);
        return response;
    }

    private FetchCommunicationDetailsResponse buildCommDetails(RequestBodyWrapper bodyWrapper) throws Exception {
        FetchCommunicationDetailsResponse communicationDetailsResponse = new FetchCommunicationDetailsResponse();
        ResponseBodyWrapper bodyWrapper1 = new ResponseBodyWrapper();
        bodyWrapper1.setResponseBody(buildResBodyObj(bodyWrapper));
        String encryptedResp = ESBEncDec.encrypt(JsonTransformer.transformToJson(bodyWrapper1),key);
        communicationDetailsResponse.setEncryptedResponse(encryptedResp);
        return communicationDetailsResponse;
    }

    private ResponseBody buildResBodyObj(RequestBodyWrapper bodyWrapper) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setEmailId("genqktest@axisbank.com");
        responseBody.setStatus("SUCCESS");
        responseBody.setMobileNumber("919881132268");
        responseBody.setSecureFlag("Y");
        responseBody.setResponceCode("000");
        return responseBody;
    }
}
