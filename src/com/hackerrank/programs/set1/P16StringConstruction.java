package com.hackerrank.programs.set1;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/string-construction/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * @result passed all test cases 
 *
 */
public class P16StringConstruction {
	
	private static String s;
	public static void main(String...strings){
		s = "abcd";
		System.out.println(stringConstruction(s));
		s = "abab";
		System.out.println(stringConstruction(s));
	}
	
	/**
	 * 
	 * @param s1
	 * @return we need to construct new string from s1, if we use a character from s1 and append it to s2, cost is $1,, if we use any substring of s2 and append back in s2 itself
	 * cost is zero. we need to return minimum cost
	 */
	private static int stringConstruction(String s1) {
		
		int cost = 0;
		for(int i = (int)'a'; i <= (int)'z'; i++){
			if(s1.contains(""+(char)i))cost++;
		}
		return cost;
    }
	
}
