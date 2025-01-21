package com.axisbank.limit.controller;

import com.axisbank.limit.Utility.JsonTransformer;
import com.axisbank.limit.dto.LoginRequest;
import com.axisbank.limit.dto.LoginResponse;
import com.axisbank.limit.dto.VerifyOTPRequest;
import com.axisbank.limit.dto.VerifyOTPResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.UUID;

@RestController
@RequestMapping("/ezwsrest/rest/engine")
@Slf4j
public class LoginVerifyOTPController {

    @PostMapping("/eziden/s/verifyAllOtp")
    public ResponseEntity<VerifyOTPResponse> validateVerifyOTP(@RequestParam String actionBy,
                                                               @RequestParam String samlId,
                                                               @RequestParam String userId,
                                                               @RequestParam String otp) {
        log.info("Login verify otp request received... Request :{} and otp :{}", userId,otp);
        if("123456".equalsIgnoreCase(otp)) {
            VerifyOTPResponse auditRes = VerifyOTPResponse.builder()
                    .traceId(UUID.randomUUID().toString())
                    .returnCode(0).build();
            return new ResponseEntity<>(auditRes, HttpStatus.OK);
        } else {
            VerifyOTPResponse auditRes = VerifyOTPResponse.builder()
                    .traceId(UUID.randomUUID().toString())
                    .returnCode(-7).build();
            return new ResponseEntity<>(auditRes,HttpStatus.OK);
        }

    }
}
