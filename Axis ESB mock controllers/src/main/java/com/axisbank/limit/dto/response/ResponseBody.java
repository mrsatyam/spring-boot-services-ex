package com.axisbank.limit.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseBody {
    @JsonProperty("chubTransId")
    private String chubTransId;

    @JsonProperty("acknowledgementId")
    private long acknowledgementId;

    @JsonProperty("errorDescription")
    private String errorDescription;

    @JsonProperty("errorCode")
    private int errorCode;

    @JsonProperty("status")
    private String status;
}
