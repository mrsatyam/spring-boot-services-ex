package com.axisbank.limit.controller;

import com.axisbank.limit.constants.AxisMessageStatusCodes;
import com.axisbank.limit.constants.HttpStatusCodes;
import com.axisbank.limit.dto.AccountDetails;
import com.axisbank.limit.dto.ResponseDto;
import com.axisbank.limit.encryption.AESEncryptionUtil;
import com.axisbank.limit.exception.AxisException;
import com.axisbank.limit.request.AccountStatusRequestWrapper;
import com.axisbank.limit.request.DemographicDetailsRequestWrapper;
import com.axisbank.limit.response.CustomerLimitDto;
import com.axisbank.limit.response.GetAccountStatusResponse;
import com.axisbank.limit.response.Header;
import com.axisbank.limit.response.Response2;
import com.axisbank.limit.response.ResponseBody2;
import com.axisbank.limit.response.ResponseDto2;
import com.axisbank.limit.response.ResponseHandler;
import com.axisbank.limit.response.ResponseWrapper;
import com.axisbank.limit.response.SubHeader;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/myapp")
public class ConfigurationController {

    @Autowired
    private AESEncryptionUtil aesEncryptionUtil;

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<ResponseDto> customers(HttpServletRequest request,
                                                 @PathVariable String customerId) throws AxisException, Exception {

        try {
            List<AccountDetails> accList = new ArrayList<>();
            accList.add(new AccountDetails("1234", "0", "A"));
            accList.add(new AccountDetails("2345", "0", "A"));
            accList.add(new AccountDetails("3456", "1", "F"));
            accList.add(new AccountDetails("4567", "0", "A"));

            return ResponseHandler.generateResponse(AxisMessageStatusCodes.S000.name(), HttpStatusCodes.OK, accList);
        } catch (AxisException e) {
            throw e;
        } catch (Exception e) {
            return ResponseHandler.generateResponse(AxisMessageStatusCodes.E500.name(), HttpStatusCodes.INTERNAL_SERVER_ERROR, null);
        }

    }

    @PostMapping("/account")
    public ResponseEntity<ResponseDto2> accountDetails(HttpServletRequest request, @RequestBody AccountStatusRequestWrapper requestBody) {
        var i = requestBody;
        requestBody.request().body().getAccountStatusRequest().encryptedRequest();
        request.getHeader("serviceRequestId");
        try {
            GetAccountStatusResponse getAccountStatusResponse = new GetAccountStatusResponse("UbXcRRUQoSD1hTDoTrZwBbXBJRLFvqhPTha5KCjI8vF3jx/acaXI5kUHQcajBnwPMvck7lx/NEqnyWWNQh5ZHnDL/H5yl28EMiFP7Tzuvz6b7mwI502j76kksy8nK4/7K9nlpiFmWz/YlwCGL9qMYjuJMHWgK5EyBbcAUPLyqYw9qRG5tLjsbg3egZoDySvy2bgO+cRaHEsfMNwu5wJb1UJeq7Qv9yQBhLlWn1jSyDNzHluYch40DhaXQiO6PaIagdj6MAtDl+/NmiySGujvK1jl4Hk=");
            ResponseBody2 responseBody = new ResponseBody2(getAccountStatusResponse);
            SubHeader subHeader = new SubHeader("43376574", "AE.FIN.SDBSP.001", "1.0", "ESB");
            Header header = new Header(subHeader);
            Response2 response = new Response2(header, responseBody);
            ResponseDto2 responseDto = new ResponseDto2(response);

            return ResponseEntity.ok(responseDto);
        } catch (AxisException e) {
            throw e;
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/demoGraphicDetails")
    public ResponseEntity<ResponseWrapper> demographicDetails(@Valid @RequestBody DemographicDetailsRequestWrapper fetchDemographicDetailsRequest, HttpServletRequest request) {
        request.getHeader("requestUUID");
        var f = fetchDemographicDetailsRequest;
        String encryptedResponse = "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";
        ResponseWrapper responseWrapper = new ResponseWrapper(new ResponseWrapper.Response(
                new ResponseWrapper.Header(new ResponseWrapper.SubHeader("123456", "AE.ESB.FIN.SDBSP.001", "1.0", "ESB")),
                new ResponseWrapper.Body(new ResponseWrapper.FetchDemographicDetailsResponse(encryptedResponse))
        ));

        return ResponseEntity.ok(responseWrapper);
    }

    @GetMapping
    public ResponseEntity<String> nameEnquiry(HttpServletRequest request) {
//        try {
//            // Simulate a delay of 10 seconds
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }

        // After the delay, send the response
        String response = "00|TRANSACTION APPROVED|SIJDFVDLZL5404|324914084072|06092023141212|SRINIVAS GOUD VASU  |3964081605";
        String responseEr = "91|TRANSACTION FAILED|||||";

        //return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
        return ResponseEntity.ok(responseEr);
    }

    @GetMapping("/fetchCustomerLienAmtAndStatusDetailsByCustId/{customerId}")
    public ResponseEntity<ResponseDto> getLimitDetails(@PathVariable String customerId,
                                                       @RequestParam(name = "schemeTypes", required = false) List<String> schemeTypes) {
        try {
            if (schemeTypes.isEmpty()) {
                schemeTypes.add("CAA");
                schemeTypes.add("SBA");
            }
            CustomerLimitDto limitDto = new CustomerLimitDto();
            limitDto.setAcid("12345");
            limitDto.setFrez_Code("A");
            limitDto.setLien_Amt("0");
            limitDto.setForacid("004010100024732");

            CustomerLimitDto limitDto2 = new CustomerLimitDto();
            limitDto2.setAcid("1234567");
            limitDto2.setFrez_Code("A");
            limitDto2.setLien_Amt("0");
            limitDto2.setForacid("922030002279333");


            CustomerLimitDto limitDto3 = new CustomerLimitDto();
            limitDto3.setAcid("12345678");
            limitDto3.setFrez_Code("A");
            limitDto3.setLien_Amt("0");
            limitDto3.setForacid("922030002279346");


            List<CustomerLimitDto> accountDetails = List.of(limitDto, limitDto2, limitDto3);
            if (accountDetails != null && !accountDetails.isEmpty()) {
                return ResponseHandler.generateResponse(AxisMessageStatusCodes.S000.name(), HttpStatusCodes.OK, accountDetails);
            } else {
                return ResponseHandler.generateResponse(AxisMessageStatusCodes.E500.name(), HttpStatusCodes.OK, accountDetails);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatusCodes.INTERNAL_SERVER_ERROR, "Try Again!");
        }
    }

}
