package com.example.finacleservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayeeNameController {

    @GetMapping("/mSwitch/impsp2p")
    public String verifyPayeeMobile(
            @RequestParam("MOB_SERVICE_PROVIDER_ID") String mobServiceProviderId,
            @RequestParam("REQUEST_ID") String requestId,
            @RequestParam("REQUEST_TYPE") String requestType,
            @RequestParam("REMITTOR_MOBILE_NUMBER") String remitterMobileNumber,
            @RequestParam("REMITTOR_MMID") String remitterMMID,
            @RequestParam("REMITTOR_ACCNT_NUM") String remitterAccountNum,
            @RequestParam("REMITTOR_NAME") String remitterName,
            @RequestParam("BENE_MOBILE_NUMBER") String beneMobileNumber,
            @RequestParam("BENE_MMID") String beneficiaryMMID,
            @RequestParam("TRAN_INIT_CHANNEL_NAME") String tranInitChannelName,
            @RequestParam("CHECKSUM") String checkSum) {

        // Assuming the processing of the request parameters and checksum validation is done here.
        
        // Example response
        String response = "00|TRANSACTION APPROVED|AFPGVJ2G0909|409918348544|08042024183119|NEILPIUSFERNANDES|2319716714";

        return response;
    }

    @GetMapping("/upload")
    public String upload(@RequestBody Object req) {

        // Assuming the processing of the request parameters and checksum validation is done here.

        // Example response
        String response = "00|TRANSACTION APPROVED|AFPGVJ2G0909|409918348544|08042024183119|NEILPIUSFERNANDES|2319716714";

        return response;
    }
}
