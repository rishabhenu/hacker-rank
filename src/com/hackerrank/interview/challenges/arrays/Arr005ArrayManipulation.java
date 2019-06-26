package com.hackerrank.interview.challenges.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arr005ArrayManipulation {

	static int n , queries[][]; static long result;
	public static void main(String...strings){
		n = 5;
		queries = new int[][]{{1,2,100},{2,5,100},{3,4,100}};		//200 expected
		result = arrayManipulation(n, queries);
		System.out.println(result);
		n = 10; queries = new int[][]{{2,6,8},{3,5,7},{1,8,1},{5,9,15}};	//31 expected
		result = arrayManipulation(n, queries);
		System.out.println(result);
		n = 40; queries = new int[][]{{29,40,787},{9,26,219},{21,31,214},{8,22,719},{15,23,102},{11,24,83},{14,22,321},{5,22,300},
									  {11,30,832},{5,25,29},{16,24,577},{3,10,905},{15,22,335},{29,35,254},{9,20,20},{33,34,351},
									  {30,38,564},{11,31,969},{3,32,11},{29,35,267},{4,24,531},{1,38,892},{12,18,825},{25,32,99},
									  {3,39,107},{12,37,131},{3,26,640},{8,39,483},{8,11,194},{12,37,502}};					//8628 expected
		result = arrayManipulation(n, queries);
		System.out.println(result);
		n = 4; queries = new int[][]{{2,3,603},{1,1,286},{4,4,882}};				//882 expected
		result = arrayManipulation(n, queries);
		System.out.println(result);
	}
	


	private static long arrayManipulation(int n, int[][] queries) {
		long[] array = new long[n];
		for(int i=0; i<queries.length; i++){
			int a = queries[i][0];
			int b = queries[i][1];
			int k = queries[i][2];
			array[a-1] += k;
			try{
				array[b] -= k;
			}catch(Exception e){}
		}
		long maxSum = 0, tempMax = 0;
		for(int i=0; i<n; i++){
			tempMax += array[i];
			if(tempMax > maxSum)maxSum = tempMax;
		}
		return maxSum;
	}



	/**
	 * 
	 * @param n
	 * @param queries
	 * @return
	 * 
	 * This method is also terminated due to time out
	 */
	static long arrayManipulationTry2(int n, int[][] queries){
		Map<Integer,Long> map = new HashMap<>();
		for(int i=0; i<queries.length; i++){
			for(int j = queries[i][0]-1; j<queries[i][1]; j++){
				if(!map.containsKey(j)){
					map.put(j, (long)queries[i][2]);
				}else{
					map.put(j, map.get(j)+queries[i][2]);
				}
			}
		}
		List<Long> list = new ArrayList<>();
		list.addAll(map.values());
		list.sort(null);
		return list.get(list.size()-1);
	}
	
	
	
	
	/**
	 * 
	 * @param n
	 * @param queries
	 * @return
	 * 
	 * this method failed because of timeout
	 */
	static long arrayManipulationTimeOut(int n, int[][] queries) {
		long array[] = new long[n];
		for( int i=0; i<queries.length; i++ ){
			int query[] = queries[i];
			for(int j=query[0]-1; j<query[1]; j++){
				array[j] += query[2];
			}
		}
		array = insertionSort(array, 0, n);
		return array[n-1];
    }
	
	private static long[] insertionSort(long[] input, int fromIndex, int toIndex) {
		for(int i=fromIndex+1; i<toIndex; i++) {
			long temp = input[i];
			int j=i;
			while(j > fromIndex && input[j-1]>temp) {
				input[j] = input[j-1];
				j--;
			}
			input[j] = temp;
		}
		return input;
	}
}
