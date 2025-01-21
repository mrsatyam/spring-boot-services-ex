package com.axisbank.limit.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Context {
    private String transId;
    private String templateId;
    private String senderId;

}
