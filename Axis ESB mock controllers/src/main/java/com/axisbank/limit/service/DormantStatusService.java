package com.axisbank.limit.service;

import com.axisbank.limit.dto.AccountDetails;
import com.axisbank.limit.dto.DataStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormantStatusService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Async
    public DataStatus dormaintServiceReturnResponse(List<AccountDetails> accountList) {
        System.out.println("dormaintServiceReturnResponse");

        boolean dormantflag = true;
        String accNum = null;
        DataStatus ds = new DataStatus();
        // dormant status service
        for (AccountDetails accDetail:accountList) {

            // get single record parse & validate response and set values in the final response
            //need to update flag value false as per business logic and also break the loop

            accNum = accDetail.getAcid();
        }
        if (dormantflag ) {
            ds.setStatuscode("Y");
            ds.setValidationmsg("Dormant Status validate successfully");
        } else {
            ds.setStatuscode("N");
            ds.setValidationmsg("Dormant Status not active for account number: " + accNum);
        }

        return ds;
    }

}
