package com.axisbank.limit.service;

import com.axisbank.limit.constants.AxisMessageStatusCodes;
import com.axisbank.limit.dto.AccountDetails;
import com.axisbank.limit.dto.DataStatus;
import com.axisbank.limit.dto.LimitDto;
import com.axisbank.limit.exception.AxisException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LimitValidateService {

    @Value("${microservice.accounts.URL}")
    private String getAccountmsUrl;

    @Autowired
    private ReKYCService reKYCService;
    @Autowired
    DormantStatusService dormantStatusService;
    @Autowired
    MobileValidateService mobileValidateService;
    @Autowired
    LienAmtService lienAmtService;
    @Autowired
    EmailService emailService;

    Logger logger = LogManager.getLogger(this.getClass());

    public LimitDto validateLimitChecks(String custid, String ch, List<String> accountnumbers, String mob) {

        System.out.println("print-1");
        logger.log(Level.INFO, "", "--- validateLimitChecks method Started --- ");
        List<AccountDetails> accountList = getAccountDetails(custid);
        LimitDto limitDto = new LimitDto();

        if(accountList!=null && !accountList.isEmpty()){
            //e-KYC - connect service
            DataStatus ds1 =  reKYCService.rekycServiceReturnResponse(accountList);
            limitDto.setKyc(ds1);

            //Mobile - connect service
            DataStatus ds2 =  mobileValidateService.mobileServiceReturnResponse(custid, mob);
            limitDto.setMobile(ds2);

            //Lien - connect service
            DataStatus ds3 =  lienAmtService.lienAmtServiceReturnResponse(accountList);
            limitDto.setLienamt(ds3);

            // dormant status service
            DataStatus ds4 =  dormantStatusService.dormaintServiceReturnResponse(accountList);
            limitDto.setAccStatus(ds4);

            // Email validate service
            DataStatus ds5 =  emailService.emailServiceReturnResponse(accountList);
            limitDto.setEmail(ds5);
        }else {
            throw new AxisException(AxisMessageStatusCodes.E213.name());
        }

        System.out.println("print-2");
        logger.log(Level.INFO, "", "--- validateLimitChecks method Ended --- ");
        return  limitDto;

    }

    private List<AccountDetails> getAccountDetails(String custId) {
        try {
            logger.log(Level.INFO, "", "--- getAccountDetails method Started --- ");
            List<AccountDetails> list;
            final String uri = getAccountmsUrl + "?customerId=" + custId;
            System.out.println("uri:: "+uri);
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(uri, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response);
            JsonNode data = json.get("data");
            ObjectReader reader = mapper.readerFor(new TypeReference<List<AccountDetails>>() {
            });
            if (data != null && !data.isEmpty()) {
                list = reader.readValue(data);
                return list;
            }
        } catch (Exception e) {
            logger.log(Level.ERROR, "Error while fetching Account details from Account-MS", e);
            throw new AxisException(AxisMessageStatusCodes.E212.name());
        }
        logger.log(Level.INFO, "", "--- getAccountDetails method Ended --- ");
        return null;

    }
}
