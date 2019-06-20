package com.hackerrank.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/gem-stones/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * @result passed all test cases
 *
 */
public class P08Gemstone {
	
	public static void main(String...strings) {
		String arr[] = new String[] {"ab", "abc", "abc"};
		System.out.println(gemstones(arr));
		
	}

	private static int gemstones(String[] arr) {
		Map<Character, Integer> map = new HashMap<>();
		String s = "";
		I:for(int i=0; i<27; i++) {
			char c = (char)((int)'a'+i);
			for(int j=0; j<arr.length; j++) {
				if(!arr[j].contains(c+"")) continue I;
			}
			s += c;
		}
		return s.length();
    }
	
}
