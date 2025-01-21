package com.axisbank.limit.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mSwitch/impsp2a")
public class VerifyPayeeController {
    @GetMapping
    public ResponseEntity<String> nameEnquiry(HttpServletRequest request) {
//        try {
//            // Simulate a delay of 10 seconds
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }

        // After the delay, send the response
        System.out.println("Verify Payee name request received: "+ request.getParameter("REMITTOR_NAME"));
        //System.out.println("REMITTOR NAME LENGTH : "+ request.getParameter("REMITTOR_NAME").length());
        String response = "00|TRANSACTION APPROVED|SIJDFVDLZL5404|324914084072|06092023141212|SRINIVAS GOUD VASU  |3964081605";
        //String responseEr = "91|TRANSACTION FAILED|||||";

        //return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
        return ResponseEntity.ok(response);
    }
}
