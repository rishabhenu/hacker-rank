package com.hackerrank.programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author rishabhenu@gmail.com
 * 
 * @source https://www.hackerrank.com/challenges/weighted-uniform-string/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
 *
 */
public class WeightedUniformString {
	
	public static void main(String...strings) {
		File file = new File("D://new.txt");
		String s = null;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			s = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(s.length());
		int[] queries = new int[] {1,3,12,5,9,10};		//expected Yes	Yes	Yes	Yes	No	No
		String[] result = weightedUniformStrings(s, new int[] {1,12});
		System.out.println(Arrays.toString(result));
	}

	/**
	 * Complete the weightedUniformStrings function in the editor below. It should
	 * return an array of strings, either Yes or No, one for each query.
	 * 
	 * weightedUniformStrings has the following parameter(s):
	 * 
	 * @param s:
	 *            a string queries: an array of integers
	 * @param queries:
	 *            an array of integers
	 * 
	 */
	public static String[] weightedUniformStrings(String s, int[] queries) {
		Map<Character, Integer> map = new HashMap<>();
		String[] resultArray = new String[queries.length];
		while(!s.isEmpty()) {
			char firstChar = s.charAt(0);
			String regex = "(["+firstChar+"]+)";
			int initialSize = s.length();
			s = s.replaceFirst(regex, "");
			int finalSize = s.length();
			int size = initialSize - finalSize;
			if(map.containsKey(firstChar)) {
				map.put(firstChar, Math.max(size, map.get(firstChar)));
			}else {
				map.put(firstChar, size);
			}
		}
		System.out.println(map);
		for(int i=0; i<queries.length; i++) {
			boolean flag = false;
			InnerLoop:
				for(char c : map.keySet()) {
					int weight = (int)c-(int)'a'+1;
//					System.out.println("char is "+c+" and weight is "+weight+", query[i] is "+queries[i]);
					if(map.get(c) > 0 && queries[i] % weight == 0 && queries[i] / weight <= map.get(c)) {
						resultArray[i] = "Yes";
						flag = true;
						break InnerLoop;
					}
				}
			if(!flag)resultArray[i] = "No";
		}
		return resultArray;
	}


/**
 * submitted passed
*/
}