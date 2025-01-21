package com.axisbank.limit.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class IAMUserRequest implements Serializable {
	
	private static final long serialVersionUID = 5180928318636493650L;
	
	private String authenticationType;
	private String custAppId;
	private String groupId;
	private String ipAddress;
	private Boolean isLoginSuccess;
	private Integer merchantId;
	private String merchantKeyword;
	private String userId;
	private String userPassword;
	
}
