package com.hackerrank.interview.challenges.p2arrays;

import java.util.Arrays;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * @result passed all test cases
 *
 */
public class Arr004MinimumSwaps2 {
	
	public static void main(String...strings){
		int arr[] = new int[]{4,3,1,2};		// expected 3
		int swaps = 0;
		swaps = minimumSwaps(arr);
		System.out.println(swaps);
		
		arr = new int[]{2,3,4,1,5};			//expected 3
		swaps = minimumSwaps(arr);
		System.out.println(swaps);
		
		arr = new int[]{1,3,5,2,4,6,7};		//expected 3
		swaps = minimumSwaps(arr);
		System.out.println(swaps);
	}
	
	/**
	 * 
	 * @param arr - this is an unsorted array which is to be sorted with minimum no of swaps and that minimum no will be returned
	 * @return no of minimum swaps required to sort the given array
	 */
	private static int minimumSwaps(int[] arr) {
		int swaps = 0;
		for(int i=0; i<arr.length-1; i++){
			if(i+1 == arr[i]){
				continue;
			}
			for(int j=i+1; j<arr.length; j++){
				if(arr[j] == i+1){
					arr = swapArray(arr, i, j);
					swaps++;
					break;
				}
			}
		}
		return swaps;
	}

	/**
	 * This method is correct but on the hacker-rank browser, it's being not passed all test cases because of terminated 
	 * due to timeout. 
	 * @param arr - this is unsorted array which is to be sorted
	 * @return no of minimum swaps required to sort the array
	 */
	@SuppressWarnings("unused")
	private static int minimumSwapsTimeOutError(int[] arr) {
		int swaps = 0;
		int index = 0;
		while(index < arr.length){
			int actualNo = index+1;
			if(arr[index] == actualNo){
				index++;
				continue;
			}else{
				int index2 = 0;
				For:
				for(int i=index; i<arr.length; i++){
					if(arr[i] == actualNo){
						index2 = i;
						swaps++;
						arr = swapArray(arr, index, index2);
						break For;
					}
				}
			}
			System.out.println(Arrays.toString(arr));
			index++;
		}
		return swaps;
    }
	
	private static int[] swapArray(int arr[], int index1, int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		return arr;
	}
}
