package com.axisbank.limit.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLimitDto {

    private String acid;

    private String frez_Code;

    private String lien_Amt;

    private String foracid;
}
