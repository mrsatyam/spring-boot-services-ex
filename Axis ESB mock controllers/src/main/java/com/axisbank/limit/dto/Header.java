package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Header {
    private SubHeader subHeader;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public static class SubHeader {
    private String requestUUID;
    private String serviceRequestId;
    private String serviceRequestVersion;
    private String channelId;
}
}
