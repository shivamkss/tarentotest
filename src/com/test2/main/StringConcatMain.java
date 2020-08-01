package com.test2.main;

import com.test2.util.StringConcatUtil;

public class StringConcatMain {

	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "12345";
		String s3 = "vwxyz";

		// check if length of all the strings is same or not
		if (!StringConcatUtil.validateIfStringsOfSameLength(s1, s2, s3)) {
			System.out.println("Strings don't have same length.");
		}

		// prepare final string
		System.out.println("Final string is " + StringConcatUtil.concatStrings(s1, s2, s3));
	}
}
