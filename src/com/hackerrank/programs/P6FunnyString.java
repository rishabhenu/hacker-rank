package com.hackerrank.programs;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/funny-string/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 *
 * @result passed all test cases
 */
public class P6FunnyString {

	public static void main(String...strings) {
		String s = "abcdefg";
		System.out.println(funnyString(s));
	}
	
	private static String funnyString(String s) {
		int[] diffActual = new int[s.length()-1];
		int[] diffReverse = new int[s.length()-1];
		for(int i=0; i<s.length()-1; i++) {
			diffActual[i] = Math.abs( (int)s.charAt(i+1) - (int)s.charAt(i) );
			int j = diffReverse.length-1-i;
			diffReverse[i] = Math.abs( (int)s.charAt(j+1) - (int)s.charAt(j) );
			System.out.println(diffActual[i]+", "+diffReverse[i]);
			if(diffActual[i] != diffReverse[i])return "Not Funny";
		}
		return "Funny";
    }
	
}
