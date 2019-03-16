package com.skillup.common;

import org.springframework.util.Assert;

/**
 * @author ssmic
 *
 */
public class CommonUtil {
	
	/**
	 * 숫자여부 판단
	 *
	 */
	public static boolean isNumeric(String arg) {
		// TODO: 숫자여부 판단 
		boolean isNumeric = false;
		return isNumeric;
	}
	/**
	 * null 값 check
	 *
	 */
	public static Boolean NullCheck(String text){
		try {
			Assert.notNull(text,"Error while Null check Logic");
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
