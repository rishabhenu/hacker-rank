package com.hackerrank.interview.challenges.p1warmup;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 * 
 * @result all test passed
 *
 */
public class WU002RepeatedString {

	public static void main(String...strings) {
		String s = "ababa";
		System.out.println(Long.MAX_VALUE);
		long n = 3;
		long result = repeatedString(s, n);
		System.out.println(result);
	}
	
	static long repeatedString(String s, long n) {
		long noOfAs = s.length() - s.replaceAll("a", "").length();
		long noOfRepeats = n/s.length();
		noOfAs *= noOfRepeats;
		int endIndex = noOfRepeats>1?(int) (n % (noOfRepeats*s.length())):(int)n;
		String wordRemaining = s.substring(0, endIndex);
		noOfAs += (wordRemaining.length() - wordRemaining.replaceAll("a", "").length());
		return noOfAs;
    }
}
