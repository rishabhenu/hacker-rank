package com.hackerrank.interview.challenges.warmup;

/**
 * 
 * @author rishabh@amitisoft.com
 * @source https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 * 
 * @resutl passed all test cases
 *
 */
public class WU001JumpingOnTheClouds {

	public static void main(String...strings) {
		int c0[] = new int[] {0, 0, 0, 1, 0, 0};
		int result = jumpingOnClouds(c0);
		System.out.println(result);
		int c1[] = new int[] {};
	}
	
	private static int jumpingOnClouds(int[] c) {
		int index = 0, steps = 0;
		for(;index < c.length-1;) {
			index = (index+2 < c.length && c[index+2]==0)?index+2:index+1;
//			if(index >= c.length) {
//				return steps;
//			}
			System.out.println(index+", "+steps);
			steps++;
		}
		return steps;
    }
	
}
