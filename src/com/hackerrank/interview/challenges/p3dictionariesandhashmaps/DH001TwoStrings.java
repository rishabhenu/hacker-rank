package com.hackerrank.interview.challenges.p3dictionariesandhashmaps;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * 
 * @result passed all test cases
 *
 */
public class DH001TwoStrings {

	public static void main(String...strings){
		String s1 = "hello";
		String s2 = "world";
		
		System.out.println(twoStrings(s1, s2));
	}
	
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return "YES" if s1 and s2 have any common substring else "NO"
	 */
	private static String twoStrings(String s1, String s2){
		while(!s1.isEmpty()){
			char c = s1.charAt(0);
			if(s2.contains(c+""))return "YES";
			s1 = s1.replaceAll(c+"", "");
		}
		return "NO";
	}
	
}
