package com.axisbank.limit.controller;

import com.axisbank.limit.dto.IAMUserRequest;
import com.axisbank.limit.dto.IAMUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mxcomponentapi/usermanagement/merchants/OC")
@Slf4j
public class UserAuthenticationController {

@PostMapping("/users/login")
    ResponseEntity<IAMUserResponse> authenticateUser(@RequestBody IAMUserRequest request) {
    log.info("Iam user authentication request received..{}", request);
    if("saty".equalsIgnoreCase(request.getUserId())) {
        IAMUserResponse response = buildAuthenticationResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

}

    private IAMUserResponse buildAuthenticationResponse() {
    return IAMUserResponse.builder()
            .userId("saty")
            .axisCustId("003000154")
            .country("12")
            .groupId("D-GroupId")
            .merchantId(444)
            .userEmail("axis-dummy@axisbank.com")
            .userKey(99)
            .userMobileNo("919999994444")
            .userName("Satyam Joshi")
            .userType("IB")
            .flexiField3("NODEBIT")
            .flexiField4("***********7507")
            .flexiField17("3|Y|0|Y")
            .flexiField19("MFALocked|N|2024-03-04||")
            .flexiField22("Web=3|Mobile=0|Hw_Mini=0|Rbaa=0")
            .build();
    }
}
