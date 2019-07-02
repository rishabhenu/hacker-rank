package com.hackerrank.interview.challenges.p2arrays;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * @result passed all test cases
 * 
 * pattern 
 * 				a[i][j]		a[i][j+1]		a[i][j+2]
 * 							a[i+1][j+1]
 * 				a[i+2][j]	a[i+2][j+1]		a[i+2][j+2]
 *
 */
public class Arr001Array2DDS {

	public static void main(String...strings) {
		int arr[][] = new int[][] {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0}}; //19 expected
		int result = hourglassSum(arr);
		System.out.println(result);
	}
	
	private static int hourglassSum(int[][] arr) {
		int sum = Integer.MIN_VALUE;
		for(int i=0; i<arr.length-2; i++) {
			for(int j=0; j<arr.length-2; j++) {
				int temp = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				sum = Integer.max(temp, sum);
			}
		}
		return sum;
	}
}
