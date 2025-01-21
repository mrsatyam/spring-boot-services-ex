package com.axisbank.limit.Utility;

import com.axisbank.limit.dto.Paginator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ClassUtil;

import java.nio.charset.StandardCharsets;

public class ApplicationUtils {

	private ApplicationUtils() {
	}


	public static void main(String[] args) {
		System.out.println(StandardCharsets.UTF_8.toString());
	}
	public static String convertToStringOrJson(Object val, ObjectMapper mapper) {
		if (isConvertToString(val.getClass())) {
			return String.valueOf(val);
		}
		try {
			return mapper.writeValueAsString(val);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isConvertToString(Class<?> clazz) {
		return clazz.equals(String.class) || ClassUtil.isObjectOrPrimitive(clazz);
	}

	public static Paginator getPaginator(Integer page, Integer pageSize) {
		if ((page == null && pageSize == null) || (page == 0 && pageSize == 0)) {
			return Paginator.builder().startIndex(0).endIndex(10000).pageSize(10000).page(page).build();
		} else if (page == 0) {
			return Paginator.builder().startIndex(0).endIndex(pageSize).pageSize(pageSize).page(page).build();
		} else {
			return Paginator.builder().startIndex(pageSize * (page)).endIndex(pageSize * (page + 1)).pageSize(pageSize)
					.page(page).build();
		}
	}


	public static void deleteLastPipe(StringBuilder parameters) {
		if (parameters != null && parameters.length() > 0)
			parameters.deleteCharAt(parameters.length() - 1);
	}

}
