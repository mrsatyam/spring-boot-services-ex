package com.axisbank.limit.dto;

//import com.axisbank.limit.entity.ConfigMap;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AxisMessages {

    private String statusCode;
    private String message;

       /* public AxisMessages(ConfigMap configMap) {
        if (configMap != null) {
            this.statusCode = configMap.getFieldName();
            this.message = configMap.getFieldValue();
        }
    }*/
}
