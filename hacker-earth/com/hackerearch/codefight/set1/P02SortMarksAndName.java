package com.hackerearch.codefight.set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 * @author Rishabh Sharma
 *
 * @desc <br/>
 * 			We have to sort the given input, where n lines contain input as < String Integer > where String is name of student <br/>
 * 			Integer is marks obtained by student out of 100. <br/>
 * 			
 * 			In the output we have to print all names according to decreasing order of marks obtained <br/>
 * 			If more than one students got same marks, we will print there names in Lexicographical order.
 * 
 * @input	first line contains an integer n denoting no of test cases <br/>
 * 			then following n lines contain String Integer where String is name and Integer is marks. both are separated by space
 */
public class P02SortMarksAndName {

	public static void main(String... strings) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter no of test cases");
		int testCases = new Integer(br.readLine());
		Map<Integer, TreeSet<String>> inputMap = new TreeMap<Integer, TreeSet<String>>();
		System.out.println("Now enter "+testCases+" space separated name and marks pair. After entering one pair, hit enter for next pair");
		for (int i = 0; i < testCases; i++) {
			String[] input = br.readLine().split(" ");
			int marks = new Integer(input[1]);
			TreeSet<String> set = null;
			if(inputMap.containsKey(marks))
				set = inputMap.get(marks);
			else
				set = new TreeSet<String>();
			set.add(input[0]);
			inputMap.put(marks, set);
		}
		br.close();
		Object[] array = inputMap.keySet().toArray();
		for (int i = array.length - 1; i >= 0; i--) {
			for (String s : inputMap.get(array[i])) {
				System.out.println(s + " " + array[i]);
			}
		}
		br.close();
	}

}
