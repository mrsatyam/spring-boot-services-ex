package com.axisbank.limit.service;

import com.axisbank.limit.dto.AccountDetails;
import com.axisbank.limit.dto.DataStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Async
    public  DataStatus emailServiceReturnResponse(List<AccountDetails> accountList) {
        System.out.println("emailServiceReturnResponse");

        boolean emailflag = true;
        String accNum = null;
        DataStatus ds = new DataStatus();
            // Re-KYC - connect service
        for (AccountDetails accDetail:accountList) {

            // Email validate service
            // parse & validate response and set values in the final response
            accNum = accDetail.getAcid();
            }
        if (emailflag ) {
            ds.setStatuscode("Y");
            ds.setValidationmsg("Email id successfully validated");
        } else {
            ds.setStatuscode("N");
            ds.setValidationmsg("Email status pending for account number: " + accNum);
        }
        
        return ds;
    }

}
