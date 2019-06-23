package com.hackerrank.programs.set1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/equality-in-a-array/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * @result passed all test cases
 *
 */
public class P12EquilizeTheArray {

	public static void main(String...strings){
		int[] arr = new int[]{3, 3, 2, 1, 3};
		int result = equalizeArray(arr);
		System.out.println(result);
	}
	
	static int equalizeArray(int[] arr) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}else{
				map.put(arr[i], 1);
			}
		}
		List<Integer> list = new ArrayList<>();
		list.addAll(map.values());
		list.sort(null);
		int highestOccurence = list.get(list.size()-1);
		return highestOccurence==1?arr.length-1:arr.length-highestOccurence;
	}

}
