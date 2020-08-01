package com.test2.util;

/**
 * This class will have helper functions dealing with multiple strings
 * 
 * @author shivam
 *
 */
public class StringConcatUtil {

	/**
	 * function to validate if all strings are of same length
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public static boolean validateIfStringsOfSameLength(String s1, String s2, String s3) {
		int stringlen = s1.length();
		if (s2.length() != stringlen || s3.length() != stringlen)
			return false;

		return true;
	}

	/**
	 * function to concat strings
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public static String concatStrings(String s1, String s2, String s3) {
		StringBuilder finalString = new StringBuilder();
		for (int i = 0; i < s1.length(); i++) {
			finalString.append(s1.charAt(i));
			finalString.append(s2.charAt(i));
			finalString.append(s3.charAt(i));
		}
		return finalString.toString();
	}
}
