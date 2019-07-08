package com.hackerrank.programs.set1;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/game-of-thrones/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * @result all test passed	<br/>
 * 
 * We are given a String, we need to return whether given String is <b>Anangram</b> of any <b>Palindrom</b> string or not?
 *
 */
public class P17GameOfThrones {
	
	public static void main(String...strings){
		String s = "abcdeabcdef";
		System.out.println(gameOfThrones(s));
	}
	
	/**
	 * 
	 * @param s --> String to be checked whether it's Anangram of palindrom String or not?
	 * @return <b>YES</b> if given String is Anangram of Palindrom else <b>NO</b>
	 */
	private static String gameOfThrones(String s){
		int countOddChars = 0;
		while(!s.isEmpty()){
			String regex = ""+s.charAt(0);
			String temp = s.replaceAll(regex, "");
			int charCounts = s.length() - temp.length();
			if(charCounts%2 == 1){
				countOddChars += 1;
				if(countOddChars == 2)return "NO";
			}
			s = temp;
		}
		return "YES";
	}

}
