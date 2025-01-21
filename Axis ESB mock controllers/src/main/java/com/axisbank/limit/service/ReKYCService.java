package com.axisbank.limit.service;

import com.axisbank.limit.constants.AxisMessageStatusCodes;
import com.axisbank.limit.dto.AccountDetails;
import com.axisbank.limit.dto.DataStatus;
import com.axisbank.limit.exception.AxisException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReKYCService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Async
    public  DataStatus rekycServiceReturnResponse(List<AccountDetails> accountList) {
        System.out.println("rekycServiceReturnResponse");
        boolean rekycflag = true;
        String accNum = null;
        DataStatus ds = new DataStatus();
            // Re-KYC - connect service
        for (AccountDetails accDetail:accountList) {

                // get single record parse & validate response and set values in the final response
                //need to update flag value false as per business logic and also break the loop
                // 1st-123-111-Y
                //5th-345-111-Y
            accNum = accDetail.getAcid();
            }
        if (rekycflag ) {
            ds.setStatuscode("Y");
            ds.setValidationmsg("RE-KYC successfully updated");
        } else {
            ds.setStatuscode("N");
            ds.setValidationmsg("RE-KYC Pending for account number: " + accNum);
        }
        
        return ds;
    }

}
