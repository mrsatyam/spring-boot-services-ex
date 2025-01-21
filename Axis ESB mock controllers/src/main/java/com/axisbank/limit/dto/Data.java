package com.axisbank.limit.dto;

import lombok.Builder;

@lombok.Data
@Builder
public class Data {
    private String toEmailId;
    private String ccEmailId;
    private String bccEmailId;
    private String phoneNo;
    private String altPhoneNo;
    private String altEmail;
    private String subject;
    private String smsg;
    private Custom custom;
}
