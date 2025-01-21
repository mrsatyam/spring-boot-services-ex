package com.axisbank.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IAMUserResponse implements Serializable {
	
	private static final long serialVersionUID = 5524015202327379716L;

	private String status;
	private Integer userKey;
	private String axisCustId;
	private String groupId;
	private String userEmail;
	private String userId;
	private String userMobileNo;
	private String userName;
	private String userType;
	private Integer merchantId;
	private String salt;
	private String country;
	private String flexiField3;
	private String flexiField4;
	private String flexiField6;
	private String flexiField7;
	private String flexiField17;
	private String flexiField19;
	private String flexiField22;
	
}
