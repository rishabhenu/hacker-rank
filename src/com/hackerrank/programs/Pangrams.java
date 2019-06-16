package com.hackerrank.programs;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/pangrams/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 *
 */
public class Pangrams {
	
	public static void main(String...strings) {
		System.out.println((int)'a'+", "+(int)'A');
		System.out.println((int)'z'+", "+(int)'Z');
		String s = "Hello";
		System.out.println(pangrams(s));
	}
	
	private static String pangrams(String s) {
        int count = 0;
        for(int i = 65; i<=90; i++) {
        	int j = i+32;
        	if(s.contains((char)i+"") || s.contains((char)j+"")) {
        		count++;
        		if(count == 26)break;
        	}
        }
        return count==26?"pangrams":"no pangrams";
    }

}

/**
 *  @status passed all test cases
 */
