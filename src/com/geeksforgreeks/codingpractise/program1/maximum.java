package com.geeksforgreeks.codingpractise.program1;
/**
	Given a struct array of type Height, having two elements feet and inches. Find the maximum height, 
	where height is calculated sum of feet and inches after converting feet into inches.

	Input:
	First line of input contains number of testcases. For each testcase, first line of input contains N, number of given heights. 
	Next line contains 2*N number of elements (feet and inches for each N).
	
	Output:
	Output maximum height from array.
	
	Your Task: Your task is to only complete the function of find maximum height from given array.
	
	Constraints:
	1<=T<=100
	1<=N<=105
	0<=Feet, Inches<=105
	
	Example:
	Input:
	2
	2
	1 2 2 1
	4
	3 5 7 9 5 6 5 5
	Output:
	25
	93
	
	Explanation:
	Testcase 1: (1, 2) and (2, 1) are respective given heights. After converting both heigths in to inches, we get 14 and 25 as respective heights. So, 25 is the maximum height.
*/
import java.util.Scanner;
public class maximum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of test cases you want to perform");
		int t = sc.nextInt();

		for(int tt=1;tt<=t;tt++) {
			System.out.println("For test case : "+tt+", Enter no of elements you want to insert");
			int n = sc.nextInt();
			Height arr[] = new Height[n];
			for (int i = 0; i < n; i++) {
				System.out.println("Height "+i);
				System.out.print("Feet = ");
				int temp1 = sc.nextInt();
				System.out.print("Inches = ");
				int temp2 = sc.nextInt();
				arr[i] = new Height(temp1, temp2);
			}

			int res = GfG.findMax(arr, n);
			System.out.println(res);
		}
	}
}