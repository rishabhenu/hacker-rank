package com.hackerearch.codefight.set1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * Oz has a list arr[] of M integers. He has to find all integers K such that :
 * 
 * 1) K > 1 2) arr[1]%K = arr[2]%K = arr[3]%K = ... = arr[M]%K where '%' is a
 * modulus operator
 * 
 * Help Oz to find all such K's.
 * 
 * @Input : First line of input contains an integer M. Then M lines follow each
 * containing one integer of the list. Input data is such that at least one
 * integer K will always exist.
 * 
 * @Output : Output all possible integers K separated by space in increasing
 * order.
 */

public class P04FindAllNumbersModuloArray {

	public static void main(String args[]) throws Exception {
		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tests = new Integer(br.readLine());
		int min = Integer.MAX_VALUE;
		int input[] = new int[tests];
		for (int i = 0; i < tests; i++) {
			if ((input[i] = new Integer(br.readLine())) < min) {
				min = input[i];
			}
		}
		br.close();
		int temp = 2;
		while (temp < min) {
			int rem = input[0] % temp;
			boolean flag = true;
			for (int i = 1; i < input.length; i++) {
				if (rem != (input[i] % temp)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.print(temp + " ");
			}
			temp++;
		}
	}
}
