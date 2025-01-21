package com.axisbank.limit.Utility;

public class CustomerAccountUtility {

	public static boolean isStaffAccount(String staffflag) {
		return (staffflag != null && staffflag.equalsIgnoreCase("Y"));
	}
}
