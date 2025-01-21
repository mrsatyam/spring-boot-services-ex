package com.axisbank.limit.Utility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.web.util.HtmlUtils;

import lombok.extern.java.Log;

@Slf4j
public class SanitizerUtils {

	/**
	 * Remove escape characters like Html/Js scripts from input if present
	 * 
	 * @param htmlString Input string
	 * @return sanitize string
	 */
	public static String sanitize(String htmlString) {
		return Jsoup.clean(HtmlUtils.htmlEscape(htmlString), Safelist.basic());
	}

	public static String cleanIt(String htmlString) {
		if (StringUtils.isEmpty(htmlString))
			return "";
		htmlString = htmlString.replaceAll("[^a-zA-Z0-9_]*", "");
		return SanitizerUtils.sanitize(htmlString);
	}

	public static List<String> cleanIt(List<String> inputs) {
		List<String> sanitizedList = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(inputs))
			inputs.stream().forEach(htmlString -> sanitizedList.add(SanitizerUtils.cleanIt(htmlString)));
		return sanitizedList;
	}
	public static List<String> accountNumbers(String str) {

		if (!str.isEmpty())
			str.split(",");
		String[] elements = str.split(",");

		List<String> fixedLenghtList = Arrays.asList(elements);

		ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);

		return listOfString;
	}


	public static void cleanIt(Object object) {
		try {
			Method[] methods = object.getClass().getDeclaredMethods();
			for (Method method : methods) {
				String methodName = method.getName();
				if (methodName.startsWith("set")) {
					String fieldName = methodName.substring(3);
					Method getMethod = object.getClass().getMethod("get" + fieldName);
					if (getMethod.getReturnType().equals(String.class)) {
						String htmlString = getMethod.invoke(object) + "";
						method.invoke(object, SanitizerUtils.cleanIt(htmlString));
					}
				}
			}
		} catch (Exception e) {
			log.error( "Error occured while sanitizing object", e);
		}

	}

	public static void main(String[] args) {
		/*String str ="{\n  \"responseType\": \"CODE\",\n  \"clientId\": \"rbxaBXzCcLzBhf6G5hvTATyR\",\n  \"redirectURL\": \"http://localhost:8180/axis-client-app-0.0.1/#/home\",\n  \"scope\": \"NA\",\n  \"state\": \"a5367043-5086-4835-a232-081191567cd4\",\n  \"userId\": \"wkhan123\",\n  \"userPassword\": \"123\"\n}";
		System.out.println(str);
		log.info("== : "+str.replaceAll("\n", ""));
		System.out.println(str.replaceAll("\n", ""));*/

		System.out.println("/OAuthIdentity/api/v1/identity/token".replace("/OAuthIdentity",""));
	}

}
