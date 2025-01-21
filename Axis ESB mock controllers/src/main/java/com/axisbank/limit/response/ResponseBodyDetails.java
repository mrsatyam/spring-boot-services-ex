package com.axisbank.limit.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public  class ResponseBodyDetails {
    @JsonProperty("matchFound")
    private final boolean matchFound;
    @JsonProperty("recordCount")
    private final int recordCount;
    @JsonProperty("basicInfo")
    private final BasicInfo basicInfo;
    @JsonProperty("addressInfo")
    private final List<AddressInfo> addressInfo;
    @JsonProperty("officeDetails")
    private final List<OfficeDetails> officeDetails;

}
