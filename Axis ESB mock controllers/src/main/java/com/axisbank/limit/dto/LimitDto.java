package com.axisbank.limit.dto;

import lombok.Data;

@Data
public class LimitDto {

    private DataStatus kyc;
    private DataStatus mobile;
    private DataStatus email;
    private DataStatus accStatus;
    private DataStatus lienamt;
}
