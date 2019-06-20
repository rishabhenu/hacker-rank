package com.hackerrank.programs;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/alternating-characters/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
 * 
 * @result passed all test cases
 *
 */
public class P09AlternatingCharacters {

	public static void main(String...strings) {
		String s = "AAAABBBBBBBBBBBBBB";
		alternatingCharacters(s);
	}
	
	private static int alternatingCharacters(String s) {
		int initLength = s.length();
		String regex = "([A]+)";
		s = s.replaceAll(regex, "A");
		regex = "([B]+)";
		s = s.replaceAll(regex, "B");
		System.out.println(s);
		return initLength - s.length();
	}
	
}
