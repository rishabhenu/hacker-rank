package com.geeksforgreeks.codingpractise.program2;

import java.util.Scanner;
import java.util.logging.Logger;

/**
	Given a string s, find the minimum number of changes required to it so that all substrings of the string become distinct.
	
	Note: length of string is atmost 26.
	
	Input:
	The first line contains an integer T, number of test cases. For each testcase there is only one line containing s atmost 26 characters.
	
	Output:
	For each testcase in new line, print the minimum number of changes to the string.
	
	Constraints:
	1 <= T <= 100
	1 <= |s| <= 26
	
	Example:
	Input
	3
	aab
	aebaecedabbee
	ab
	
	Output
	1
	8
	0
	
	Explanation
	Testcase 1: If we change one instance of 'a' to any character from 'c' to 'z', we get all distinct substrings.
	Testcase 2:  We need to change 2 a's, 2 b's and 4 e's to get distinct substrings.
	Testcase 3: As no change is required hence 0.
*/
public class GFG {
	private final static Logger logger = Logger.getLogger(GFG.class.getName()) ;
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of test cases");
		int testCases = scanner.nextInt();
		String[] inputs = new String[testCases];
		System.out.println("Enter "+testCases+" inputs");
		for(int i=0;i<inputs.length;i++){
			String input = acceptInput(scanner);
			inputs[i] = input;
		}
		StringBuilder sb = new StringBuilder("inputs taken successfully, here they are [ ");
		for(String s:inputs){
			sb.append(s+", ");
		}
		sb.append("]");
		logger.info(sb.toString());
		
		sb = new StringBuilder("Result Array [ ");
		for(int i:getMinChanges(inputs)){
			sb.append(i+", ");
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	private static int[] getMinChanges(String[] inputs){
		int result[]=new int[inputs.length];
		for(int i=0;i<inputs.length;i++){
			result[i] = getMinChanges(inputs[i]);
		}
		return result;
	}
	
	private static int minChanges;
	private static int getMinChanges(String input){
		if(input.length()>0){
			char c=input.charAt(0);
			for(int i=0;i<input.length();i++){
				if(input.charAt(i)==c){
					minChanges++;
					input=input.replace(""+input.charAt(i), "");
				}
			}
			minChanges-=1;
			System.out.println("first return "+input+" minChanges "+minChanges);
			return getMinChanges(input);
		}
		int result = minChanges;
		minChanges=0;
		return result;
	}
	
	private static String acceptInput(Scanner scanner){
		String input = scanner.next();
		if(input.length()>26 || input.length()<=0){
			System.out.println("Please enter valid string having characters range 1-26");
			return acceptInput(scanner);
		}
		return input;
	}
}
