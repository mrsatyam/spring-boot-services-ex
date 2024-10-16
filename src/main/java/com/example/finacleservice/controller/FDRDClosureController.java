package com.example.finacleservice.controller;

import com.example.finacleservice.enc.AES128;
import com.example.finacleservice.request.CloseFDRDRequest;
import com.example.finacleservice.response.CloseFDRDErrorResponse;
import com.example.finacleservice.response.CloseFDRDResponse;
import com.example.finacleservice.response.CloseFDRDResponsePlain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/finacle/tdaccount-partial-full-closure/enc")
public class FDRDClosureController {

    @PostMapping("/close")
    public ResponseEntity<Object> closeFDRD(@RequestBody CloseFDRDRequest request) throws JsonProcessingException, InterruptedException {
        // Process the request and generate CloseFDRDResponsePlain
        return generateResponseBody(request);
    }

    private ResponseEntity<Object> generateResponseBody(CloseFDRDRequest request) throws JsonProcessingException, InterruptedException {
        // Here you can generate the CloseFDRDResponsePlain based on the request
        // For simplicity, let's create a sample CloseFDRDResponsePlain

        CloseFDRDResponsePlain.ResponseBody responseBody = new CloseFDRDResponsePlain.ResponseBody(
                "N",
                "",
                "S",
                "2.500000",
                "2.500000",
                "0.00",
                "0.00",
                "0.00",
                "2.500000",
                "0.00",
                "889088778",
                "0",
                "21-02-2023 00:00:00",
                "5000.00",
                "0.00",
                "10.00",
                "0.00"
        );
        CloseFDRDResponsePlain closeFDRDResponsePlain = new CloseFDRDResponsePlain(responseBody);

        CloseFDRDResponse.SubHeader subHeader = new CloseFDRDResponse.SubHeader(
                request.request().header().subHeader().requestUUID(),
                request.request().header().subHeader().serviceRequestId(),
                request.request().header().subHeader().serviceRequestVersion(),
                request.request().header().subHeader().channelId()
        );

        CloseFDRDResponse.Header header = new CloseFDRDResponse.Header(subHeader);

        CloseFDRDResponse.CloseResponse closeResponse = new CloseFDRDResponse.CloseResponse(
                AES128.encrypt(new ObjectMapper().writeValueAsString(closeFDRDResponsePlain), "IBB741345368e9c11e9ae4b0a0950d80000")
        );
        //Thread.sleep(15000);
        CloseFDRDResponse.Body body = new CloseFDRDResponse.Body(closeResponse);
        //return ResponseEntity.ok(new CloseFDRDResponse(new CloseFDRDResponse.Response(header, body)));
        return ResponseEntity.unprocessableEntity().body(new CloseFDRDErrorResponse(new CloseFDRDErrorResponse.ErrorResponse(header, new CloseFDRDErrorResponse.Error("881", "Insufficient balance"))));
    }
}
