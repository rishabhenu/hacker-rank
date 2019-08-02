package com.hackerrank.toberemember.challenges;

/**
 * 
 * @author Rishabh Sharma
 *	
 * @desc this program is basically based on dynamic programming. We are supposed to return the length of <br/>
 * highest common subsequent string.
 * 
 * @result passed all test cases
 */
public class P004HighestCommonSubsequence {
	
	public static void main(String...strings) {
		
		String s1 = "abcdef";
		String s2 = "acdefb";
		
		System.out.println(maxCommonSubsequence(s1,s2));
		
	}

	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return,, we need to return length highest child of s1 and s2. Child means, for example <br/>
	 * 		s1 = abcdef and s2 = acdefb now we can get <b>acdef</b> which can be obtained from both s1 and s2 so we will return 5.
	 */
	private static int maxCommonSubsequence(String s1, String s2) {
		
		int array[][] = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					array[i+1][j+1] = array[i][j]+1;
				}else {
					array[i+1][j+1] = Integer.max(array[i][j+1], array[i+1][j]);
				}
			}
		}
		return array[s1.length()][s2.length()];
	}

}
