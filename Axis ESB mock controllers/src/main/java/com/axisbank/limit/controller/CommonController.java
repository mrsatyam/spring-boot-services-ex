package com.axisbank.limit.controller;

import com.axisbank.limit.dto.UserValidationRequest;
import com.axisbank.limit.dto.UserValidationResponse;
import com.axisbank.limit.ratelimit.WithRateLimitProtection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5000/", maxAge = 3600)
@RestController
@RequestMapping("/api/login/oauth")
@Slf4j
public class CommonController {


    @PostMapping("/access-token")
    public ResponseEntity<UserValidationResponse> validateUser(@RequestBody UserValidationRequest request){
        log.info("User validation request received : "+request);
        Map<String,String> map = new HashMap();
        map.put("","");
        UserValidationResponse res = new UserValidationResponse();
        res.setMessage("Token validated successfully");
        res.setToken("UdP7eUZP5UwexsawwBQedZuSZNgLTKjs2NpjynCgQEw=");
        res.setStatus("success");
        return new ResponseEntity(res, HttpStatus.OK);

    }

    @GetMapping("/users")
    @WithRateLimitProtection
    public ResponseEntity<UserValidationResponse> getUsers(){
        log.info("User request received : ");
        UserValidationResponse res = new UserValidationResponse();
        res.setMessage("Token validated successfully");
        res.setToken("UdP7eUZP5UwexsawwBQedZuSZNgLTKjs2NpjynCgQEw=");
        res.setStatus("success");
        return new ResponseEntity(res, HttpStatus.OK);

    }
}
