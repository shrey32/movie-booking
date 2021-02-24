package com.shrey.moviebooking.commons.utils;

import java.util.regex.Pattern;

/**
 * 
 * @author Shrey
 *
 */
public class MovieBookingUtility {

	/**
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {
		String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).matches();
	}

	/**
	 * 
	 * @param mobileNumber
	 * @return
	 */
	public static boolean isValidMobileNumber(String mobileNumber) {
		String regex = "^(?!0+$)(\\+\\d{1,3}[- ]?)?(?!0+$)\\d{10}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(mobileNumber).matches();
	}

}
