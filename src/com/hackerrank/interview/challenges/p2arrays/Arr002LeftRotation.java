package com.hackerrank.interview.challenges.p2arrays;

import java.util.Arrays;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays&h_r=next-challenge&h_v=zen
 *
 * @result = passed all test cases
 */

public class Arr002LeftRotation {
	
	public static void main(String...strings) {
		int arr[] = new int[] {1, 2, 3, 4, 5};
		int newArray[] = new int[arr.length];
		System.arraycopy(arr, 2, newArray, 1, 2);
		System.out.println(Arrays.toString(arr));
		arr = rotLeft(arr, 5);
		System.out.println(Arrays.toString(arr));
	}

	static int[] rotLeft(int[] a, int d) {
		d = d%a.length;
		if(d == 0)return a;
		int temp[] = new int[a.length];
		System.arraycopy(a, d, temp, 0, a.length-d);
		System.arraycopy(a, 0, temp, a.length-d, d);
		return temp;
	}
}
