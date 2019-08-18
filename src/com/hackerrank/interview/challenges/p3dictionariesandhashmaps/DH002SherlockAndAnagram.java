package com.hackerrank.interview.challenges.p3dictionariesandhashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Rishabh Sharma
 *
 * @desc https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 *       <br/>
 *       We are supposed to find number of Anagrams substring pairs of given
 *       String
 *       
 * @result	Passed All test cases
 * 
 * @logic	Basically, find all the substrings and put in a map after sorting, with value as number of occurrences
 * 			Then for every n occurrences, there are Sum(n-1) pairs. Sum(n-1) is sum of first 'n-1' natural numbers
 * 
 */
public class DH002SherlockAndAnagram {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		Map<Integer, Collection<Integer>> map = new HashMap<>();
		for (int i = 1; i < s.length(); i++) {
			map.put(i, countSubStringsOfSize(s, i));
		}
		int result = 0;
		for (Collection<Integer> collection : map.values()) {
			for (int num : collection) {
				result += getSumOfFirstNNumbers(num - 1);
			}
		}
		return result;
	}

	private static Map<Integer, Integer> sumOfFirstNNumbers = new HashMap<>();

	public static int getSumOfFirstNNumbers(int n) {
		if (!sumOfFirstNNumbers.containsKey(n))
			sumOfFirstNNumbers.put(n, (n * (n + 1)) / 2);
		return sumOfFirstNNumbers.get(n);
	}

	private static Collection<Integer> countSubStringsOfSize(String s, int size) {
		char[] input = s.toCharArray();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i <= s.length() - size; i++) {
			char[] now = Arrays.copyOfRange(input, i, i + size);
			Arrays.sort(now);
			System.out.println(Arrays.toString(now));
			String key = new String(now);
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		// System.out.println(map);
		return map.values();
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = new Integer(br.readLine());
		
		for (int qItr = 0; qItr < testCases; qItr++) {
			
			String s = br.readLine();
			int result = sherlockAndAnagrams(s);
			System.out.println("Result is : " + result);

		}

		br.close();
	}
}
