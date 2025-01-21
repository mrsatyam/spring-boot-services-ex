package com.axisbank.limit.service;

import com.axisbank.limit.constants.AxisMessageStatusCodes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.axisbank.limit.dto.AxisMessages;


@Service
public class AxisMessageService {

       public AxisMessages findAxisMessageByStatusCode(String statusCode) {

           String errorMsg;
           switch (statusCode){
               case "E213":
                   errorMsg = AxisMessageStatusCodes.E213.getMessage();
                   break;
               case "E212":
                   errorMsg = AxisMessageStatusCodes.E212.getMessage();
                   break;
               case "E001":
                   errorMsg = AxisMessageStatusCodes.E001.getMessage();
                   break;
               case "S221":
                   errorMsg = AxisMessageStatusCodes.S221.getMessage();
                   break;
               case "E500":
                   errorMsg = AxisMessageStatusCodes.E500.getMessage();
                   break;
               default:
                   errorMsg = "";
                   break;
           }
           AxisMessages axisMessages = new AxisMessages(statusCode, errorMsg);
        if (axisMessages != null && StringUtils.isNotBlank(axisMessages.getStatusCode())) {
            return axisMessages;
        } else {
            return null;
        }
    }


}
