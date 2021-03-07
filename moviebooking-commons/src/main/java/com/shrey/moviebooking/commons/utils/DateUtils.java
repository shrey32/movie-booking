package com.shrey.moviebooking.commons.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Shrey
 *
 */
public class DateUtils {

	/**
	 * 
	 * @param dateStr
	 * @return
	 */
	public static LocalDateTime convertEventDateTimeStr(String dateStr) {
		return strToLocalDateTime(dateStr, MovieBookingConstants.EVENT_DATE_FORMAT);
	}

	/**
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static LocalDateTime strToLocalDateTime(String dateStr, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.parse(dateStr, formatter);
	}

	/**
	 * to store current time when inserting a record in DB
	 * 
	 * @return
	 */
	public static LocalDateTime dbAuditDateTime() {
		return LocalDateTime.now();//strToLocalDateTime(LocalDateTime.now().toString(), MovieBookingConstants.DB_DATE_FORMAT);
	}

	/**
	 * 
	 * @param hour
	 * @return
	 */
	public static LocalDateTime timeAfterHours(long hour) {
		return LocalDateTime.now().plusHours(hour);
	}

	/**
	 * 
	 * @param hour
	 * @return
	 */
	public static LocalDateTime timeAfterMinutes(long minutes) {
		return LocalDateTime.now().plusMinutes(minutes);
	}

	public static ZoneId defaultZoneId() {
		return ZoneId.systemDefault();
	}

}
