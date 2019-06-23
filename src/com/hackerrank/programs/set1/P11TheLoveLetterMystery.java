package com.hackerrank.programs.set1;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/the-love-letter-mystery/problem?h_r=next-challenge&h_v=zen
 * 
 * @result passed all test cases 
 *
 */
public class P11TheLoveLetterMystery {
	
//	4
//	abc
//	abcba
//	abcd
//	cba
//
//	Sample Output
//
//	2
//	0
//	4
//	2

	
	public static void main(String...strings) {
		String s = "abcd";
		System.out.println(theLoveLetterMystery(s));
	}
	
	private static int theLoveLetterMystery(String s) {
		int steps = 0;
		int limit = ((s.length()%2==0)?s.length()/2:(s.length()-1)/2);
		for(int i=0; i<limit; i++){
			steps += Math.abs((int)s.charAt(i) - (int)s.charAt(s.length()-1-i));
		}
		return steps;
    }

}
