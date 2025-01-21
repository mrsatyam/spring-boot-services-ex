package com.axisbank.limit.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogInfo {
    private String system;
    private String msgGenTime;
    private String msgPutTime;
}
