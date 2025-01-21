package com.axisbank.limit.dto;

import com.axisbank.limit.response.AddressInfo;
import com.axisbank.limit.response.OfficeDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBody1 {
    private AddressInfo addressInfo;
    private OfficeDetails officeDetails;
}
