package com.example.finacleservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/finacle-service")
public class FinacleAPIResponseController {

    @PostMapping(value = "/getFinacleAPIResponse", produces = MediaType.APPLICATION_XML_VALUE)
    public String getFinacleAPIResponse() {
        String responseXml = """
                <FIXML xsi:schemaLocation="http://www.finacle.com/fixml executeFinacleScript.xsd"
                    xmlns="http://www.finacle.com/fixml"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <Header>
                        <ResponseHeader>
                            <RequestMessageKey>
                                <RequestUUID>61552030</RequestUUID>
                                <ServiceRequestId>Axis_tdAcctClsWrapper</ServiceRequestId>
                                <ServiceRequestVersion>10.2</ServiceRequestVersion>
                                <ChannelId>IBB</ChannelId>
                            </RequestMessageKey>
                            <ResponseMessageInfo>
                                <BankId>01</BankId>
                                <TimeZone>GMT+05:30</TimeZone>
                                <MessageDateTime>2024-03-12T11:07:33.053</MessageDateTime>
                            </ResponseMessageInfo>
                            <UBUSTransaction>
                                <Id/>
                                <Status/>
                            </UBUSTransaction>
                            <HostTransaction>
                                <Id/>
                                <Status>SUCCESS</Status>
                            </HostTransaction>
                            <HostParentTransaction>
                                <Id/>
                                <Status/>
                            </HostParentTransaction>
                            <CustomInfo/>
                        </ResponseHeader>
                    </Header>
                    <Body>
                        <executeFinacleScriptResponse>
                            <ExecuteFinacleScriptOutputVO></ExecuteFinacleScriptOutputVO>
                            <executeFinacleScript_CustomData>
                                <flg>N</flg>
                                <flgDate></flgDate>
                                <successOrFailure>S</successOrFailure>
                                <norIntPcnt>0.000000</norIntPcnt>
                                <effIntPcnt>0.000000</effIntPcnt>
                                <normalIntAmt>0</normalIntAmt>
                                <actualIntAmt>0</actualIntAmt>
                                <penalIntAmt>0</penalIntAmt>
                                <penalIntPcnt>0.000000</penalIntPcnt>
                                <totPenal>0.00</totPenal>
                                <foracid>924050051875303</foracid>
                                <intRecov>0</intRecov>
                                <clvaldt>12-03-2024 00:00:00</clvaldt>
                                <depAmt>5000.00</depAmt>
                                <intTaken>0.00</intTaken>
                                <withdrwlAmt>5000.00</withdrwlAmt>
                                <lienAmt>0.00</lienAmt>
                            </executeFinacleScript_CustomData>
                        </executeFinacleScriptResponse>
                    </Body>
                </FIXML>
                """;

        return responseXml;
    }

}