package com.axisbank.limit.service;

import com.axisbank.limit.dto.AccountDetails;
import com.axisbank.limit.dto.DataStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileValidateService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Async
    public DataStatus mobileServiceReturnResponse(String custId, String mob) {
        System.out.println("mobileServiceReturnResponse");

        DataStatus ds = new DataStatus();
        // Mobile service - connect service
        // parse & validate response and set values in the final response


        if (true) { //response.getvalue()==""
            ds.setStatuscode("Y");
            ds.setValidationmsg("Mobile service validated successfully");
        } else {
            ds.setStatuscode("N");
            ds.setValidationmsg("Mobile updated on date :+ response.getmobDate() " );
        }

        return ds;
    }

}
