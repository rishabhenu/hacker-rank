package com.hackerrank.interview.challenges.p2arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * @result passed all test cases 
 *
 */
public class Arr003NewYearChaos {
	
	private static int count;

	public static void main(String...strings) throws Exception {
		String s[] = new BufferedReader(new FileReader(new File("D://new.txt"))).readLine().split(" ");
		System.out.println("file read successfully");
		int q[] = new int[s.length];
		for(int i=0; i<s.length; i++) {
			q[i] = new Integer(s[i]);
		}
		System.out.println("string is copied to numbered array with length "+q.length);
		minimumBribes(q);
		System.out.println("function call end");
	}
	
	private static void minimumBribes(int[] q) {
		int index = q.length-1;
		int bribes = 0;
		while(index > 1) {
			int actualNum = index+1;
			if(q[index] == actualNum) {
				
			}else if(q[index-1] == actualNum) {
				q[index-1] = q[index];
				q[index] = actualNum;
				bribes+=1;
			}else if(q[index-2] == actualNum) {
				q[index-2] = q[index-1];
				q[index-1] = q[index];
				q[index] = actualNum;
				bribes+=2;
			}else {
				System.out.println("Too Chaoitic");
				return;
			}
			index--;
		}
		bribes = ((q[1]==2&&q[0]==1)?bribes:bribes+1);
		System.out.println(bribes);
	}
	
}
