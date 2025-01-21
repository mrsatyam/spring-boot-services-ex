package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChanCode {
    private String channelCode;
    private String customerId;
    private String prodCode;
    private String prodValue;
    private String emailId;
    private String mobileNumber;
}
