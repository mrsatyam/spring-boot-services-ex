package com.example.finacleservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
public class SoapController {

    @PostMapping(value = "/mob-email", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String handleSoapRequest(@RequestBody String request) {
        // Log the incoming request (for debugging purposes)
        System.out.println("Received Request: " + request);

        // Create the response
//        ResponseEnvelope response = new ResponseEnvelope();
//        response.setHeader(null);
//        response.setBody(new ResponseEnvelope.Body());

        return """
                <NS1:Envelope xmlns:NS1="http://schemas.xmlsoap.org/soap/envelope/">
                   <NS1:Header>
                      <NS2:subHeader xmlns:NS2="http://www.axisbank.com">
                         <NS2:RequestUUID>test567</NS2:RequestUUID>
                         <NS2:ServiceRequestId>AE.ESB.SSTP.001</NS2:ServiceRequestId>
                         <NS2:ServiceRequestVersion>1.0</NS2:ServiceRequestVersion>
                         <NS2:ChannelId>ESB</NS2:ChannelId>
                      </NS2:subHeader>
                   </NS1:Header>
                   <NS1:Body>
                      <NS3:getMobEmailDtlsResponse xmlns:NS3="http://www.axisbank.com">
                         <NS3:encryptedResponse>LGl+EIfTljvOxARzs335vm4RYaBFWEv1UkTCz1xpjEBIMg/alpjoNg1PsZL3DGhzTjg4CtRIF9ee//s63HMqY+20OB5vw5bwctlenhMEXbav71Lg4TDmkos/xCUnplK2UQ6L3/39zFO1ps60NCP4SoAUtAIU1xqi4wRfn2lg4CdnQJdpM6M+Sj95IEW9qAW058dppKashZZKDsa0PxjwKi/g7hdtuTqKhgKj1rfNp+DX/jUfgRO+K1+11fH88qL+FXBWMFnt7PoKsFcEf/vH0QI5RFqeQwYE7Clcxt5xJMP5aq/kyPXcDDKyvZqwjnrICFwa8/q3lmWtYVR1tK26b6STgvoEr9LYbEngKsN2XhzO13yGGbNIeDhOAozeegGOw2V4bA==</NS3:encryptedResponse>
                      </NS3:getMobEmailDtlsResponse>
                   </NS1:Body>
                </NS1:Envelope>
                """;
    }
}
