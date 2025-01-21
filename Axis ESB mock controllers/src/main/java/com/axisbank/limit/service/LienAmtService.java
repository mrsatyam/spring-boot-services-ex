package com.axisbank.limit.service;

import com.axisbank.limit.dto.AccountDetails;
import com.axisbank.limit.dto.DataStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LienAmtService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Async
    public DataStatus lienAmtServiceReturnResponse(List<AccountDetails> accountList) {
        System.out.println("lienAmtServiceReturnResponse");
        boolean lienAmtflag = true;
        String accNum = null;
        DataStatus ds = new DataStatus();

        for (AccountDetails accDetail:accountList) {

            // Lien amount and freez status service
            // parse & validate response and set values in the final response
            accNum = accDetail.getAcid();
            }
        if (lienAmtflag ) {
            ds.setStatuscode("Y");
            ds.setValidationmsg("Lien Amount successfully validate");
        } else {
            ds.setStatuscode("N");
            ds.setValidationmsg("Lien Amount is more then 0 for account number: " + accNum);
        }
        
        return ds;
    }

}
