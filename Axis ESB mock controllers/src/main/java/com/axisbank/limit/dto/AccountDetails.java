package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails {

	private String acid;
	private String lienAmt;
	private String freezeCode;


}
