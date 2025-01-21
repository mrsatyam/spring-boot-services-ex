package com.axisbank.limit.controller;


import com.axisbank.limit.dto.request.UpdateReconDataEncRequest;
import com.axisbank.limit.dto.response.UpdateReconDataEncResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChubReconUpdateController {

    @PostMapping("/mock/update-recon-data")
    public UpdateReconDataEncResponse mockUpdateReconData(@RequestBody UpdateReconDataEncRequest request) {
        // Log the incoming request for debugging purposes
        System.out.println("Received request: " + request);

        // Create a mocked response
        return new UpdateReconDataEncResponse(
            new UpdateReconDataEncResponse.Response(
                new UpdateReconDataEncResponse.Response.Header(
                    new UpdateReconDataEncResponse.Response.Header.SubHeader(
                        "test666",
                        "AE.ESB.SDBSP.001",
                        "1.0",
                        "ESB"
                    )
                ),
                new UpdateReconDataEncResponse.Response.Body(
                    new UpdateReconDataEncResponse.Response.Body.UpdateReconDataResponse(
                        "RG9Ob3RDaGFuZ2VUaGVTdHJpbmfULF+c6CP53fBaiFUD+MXrfyJi22uaipl1cAdRcmnT0bSrHrLUezTnwfC0PlrEW8NfO/IrhN50FALnfCDELwetH3ej5SnSs7LWaSc8r3UuujExQFRRkpY4SwQ7dvmgFwUoXwFN8X9ziCcGw3SGirhL"
                    )
                )
            )
        );
    }
}
