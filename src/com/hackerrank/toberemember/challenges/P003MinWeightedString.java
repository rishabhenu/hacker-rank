package com.hackerrank.toberemember.challenges;

import java.util.Arrays;

/**
 * 
 * @author rishabhenu@gmail.com
 * <br/>
 * 
 * Weight of a character A-Z is defined as  <br/>
 * 
 * 	A	=	1 <br/>
 * 	B	=	2*A + A	<br/>
 * 	C	=	3*B	+ B ...so on so <br/>
 * 
 * 	complete a function where input is given as a number i.e. weight,, we are supposed to return a String whose weight is exactly same as given input weight.
 * 
 * 	if more than one solutions exist, we need to return the String of minimum lenght among the results	<br/>
 *
 *	This question was asked in soroco company interview test on hackerrank
 */
public class P003MinWeightedString {
	
	public static void main(String...strings){
		long weight = 100;
		System.out.println(getMinimumWeightedString(weight));
	}

	private static String getMinimumWeightedString(long weight) {
		long array[] = new long[21];
		int index = 0;
		for(int i=(int)'A'; i<=(int)'U'; i++){
			array[index] = getWeightOfChar((char)i);
			if(array[index] == weight) return ""+(char)i;
			index++;
		}
		return getMinimumWeightedString(weight, array);
	}
	
	private static String getMinimumWeightedString(long weight, long[] array) {
		int index = 0;
		for(int i=0; i<array.length; i++){
			if(weight == array[i])return ""+(char)(i+(int)'A'); 
		}
		for(int i=0; i<array.length; i++){
			if(weight < array[i]){
				index = i-1;
				break;
			}
		}
		String resultString = ""+((char)(index+(int)'A'));
		System.out.println("index is "+index+" and weight is "+array[index]);
		resultString = getMinimumWeightedString(weight - array[index], array) + resultString;
		return resultString;
	}

	private static long getWeightOfChar(char c){
		if(c == 'A') return 1;
		long weight = 0;
		char previous = (char)((int)c - 1);
		int number = (int)c - (int)'A' + 2;
		weight += number*getWeightOfChar(previous);
		return weight;
	}
}
