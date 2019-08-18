package com.hackerrank.programs.set1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Rishabh Sharma
 * 
 * @source https://www.hackerrank.com/challenges/big-sorting/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * @desc	We are given very very big number in form of String. The numbers are large enough that they can't fit in any mathematical data-type
 * 
 * @logic	Basically sort the String treating it as number i.e. if length is not same, then bigger length string is larger (length denotes digits).<br/>
 * 			if length is same, any first occurrence of character mismatch, the string having lower character will be less. 
 * 
 * 
 */
public class P18BigSorting {
	
	public static void main(String...strings) {
		
		String input[] = null;
		input = new String[]{"31415926535897932384626433832795","1","3","10","3","5"};
//		input = new String[] {"3", "3"};
		printArray(bigSorting(input));			// expected 1,    3,    3,    5,    10,    31415926535897932384626433832795
		
	}
	
	private static void printArray(String array[]) {
		for(String s : array) {
			System.out.println(s);
		}
	}
	
	private static String[] bigSorting(String[] input) {
		Arrays.sort(input, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length())return o1.length() - o2.length();
				int index = 0;
				while( index < o1.length() && o1.charAt(index) == o2.charAt(index) ) {
					index++;
				}
				if(index >= o1.length())return 0;
				return o1.charAt(index) - o2.charAt(index);
			}
		});
		return input;
	}

	@SuppressWarnings("unused")
	@Deprecated
	/**
	 * 
	 * @param input
	 * @param startIndex
	 * @param endIndex
	 * @return	This method is deprecated because it was giving error.
	 */
	private static String[] bigSorting(String[] input, int startIndex, int endIndex) {
		if(input.length == 0 || startIndex >= endIndex)return input;
		int low = startIndex, high = endIndex;
		while(low < high) {
			System.out.println(Arrays.toString(input));
			int middle = (low+high)/2;
			String middleEle = input[middle];
			while(input[low].length() < middleEle.length() || 
					(input[low].length() == middleEle.length() && input[low].compareTo(middleEle) < 0)) {
				low ++;
			}
			while(input[high].length() > middleEle.length() || 
					(input[high].length() == middleEle.length() && input[high].compareTo(middleEle) > 0)) {
				high--;
			}
			if(low <= high) {
				input = swap(input, low, high);
				low++;
				high--;
			}
			if(startIndex < high) {
				input = bigSorting(input, startIndex, high);
			}
			if(endIndex > low) {
				input = bigSorting(input, low, endIndex);
			}
		}
		return input;
	}

	private static String[] swap(String[] input, int low, int high) {
		String temp = input[low];
		input[low] = input[high];
		input[high] = temp;
		return input;
	}

}
