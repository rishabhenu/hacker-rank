package com.hackerrank.programs.set1;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * 
 * @result passed all test cases in first attempt only
 *
 */
public class P15OrganizingContainersOfBalls {
	
	private static int[][] container;
	public static void main(String...strings){
		container = new int[][]{{1,3,1},{2,1,2},{3,3,3}};			//impossible
		System.out.println(organizingContainers(container));		
		
		container = new int[][]{{0,2,1},{1,1,1},{2,0,0}};
		System.out.println(organizingContainers(container));		//possible
	}
	
	static String organizingContainers(int[][] container) {
		Set<Long> typeOfBalls = new TreeSet<>();
		Set<Long> boxCapacity = new TreeSet<>();
		for(int i=0; i<container.length; i++){
			long tempTypeOfBalls = 0, tempBoxCapacity = 0;
			for(int j=0; j<container[i].length; j++){
				tempBoxCapacity += container[i][j];
				tempTypeOfBalls += container[j][i];
			}
			typeOfBalls.add(tempTypeOfBalls);
			boxCapacity.add(tempBoxCapacity);
		}
		if(boxCapacity.containsAll(typeOfBalls)) return "Possible";
		return "Impossible";
    }

}
