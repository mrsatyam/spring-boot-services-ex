package com.axisbank.limit.Utility;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

	public static Date startOfDay(Date date) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
		return localDateTimeToDate(startOfDay);
	}

	public static Date endOfDay(Date date) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
		return localDateTimeToDate(endOfDay);
	}

	private static Date localDateTimeToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date epochToDate(Long epoch) {
		return new Date(epoch);
	}

//	public static Date covertDateTime(Date inputDate, String dateTimeFormat, TimeZone timezone) {
//		if(inputDate !=null && StringUtils.isNoneEmpty(dateTimeFormat)) {
//			DateFormat indianFormat = new SimpleDateFormat(dateTimeFormat);
//			indianFormat.setTimeZone(timezone);
//			String convertedDate = indianFormat.format(inputDate);
//			return dateFromString(convertedDate, dateTimeFormat);
//		}
//		return null;
//	}
//
//	public static Date dateFromString(String date, String dateFormat) {
//		try {
//			DateFormat format = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
//			return format.parse(date);
//		} catch (ParseException e) {
//			log.log(Level.SEVERE, "Error while parsing date string in dateFromString method", e);
//		}
//		return null;
//	}
//	
//	public static String stringFromDate(Date date, String dateFormat) {
//		try {
//			DateFormat format = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
//			return format.format(date);
//		} catch (Exception e) {
//			log.log(Level.SEVERE, "Error while parsing date string in stringFromDate method", e);
//		}
//		return null;
//	}

	public static String removeZ(Instant now){
		// Create a formatter without the time zone indicator
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of("UTC"));

		// Create a formatter without the time zone indicator
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		String formattedDateTime = formatter.format(zonedDateTime);
		return formattedDateTime;
		//System.out.println("Formatted DateTime: " + formattedDateTime);
	}

	public static void main(String[] args) {
		System.out.println("\"PINVERREQ\"");
		System.out.println(removeZ(Instant.now()));
	}
}
