package com.hackerrank.programs.set1;

import java.math.BigInteger;
import java.util.Arrays;
/**
 * 
 * @author rishbahenu@gmail.com
 * @source https://www.hackerrank.com/challenges/acm-icpc-team/problem
 * 
 * @result passed all test cases
 *
 */
public class P13ACMICPCTeam {

	public static void main(String...strings){
		String topic[] = new String[]{"10101","11100","11010","00101"};
		System.out.println(Arrays.toString(acmTeam(topic)));
	}
	
	static int[] acmTeam(String[] topic) {
		int maxTopics = 0;
		int maxTeams = 0;
		for(int i=0; i<topic.length; i++){
			for(int j=i+1; j<topic.length; j++){
				BigInteger bi = new BigInteger(topic[i],2);
				BigInteger bj = new BigInteger(topic[j],2);
				int bitCount = (bi.or(bj)).bitCount();
				
				if(bitCount > maxTopics){
					maxTopics = bitCount;
					maxTeams = 1;
				}else if(bitCount == maxTopics){
					maxTeams += 1;
				}
			}
		}
		return new int[]{maxTopics, maxTeams};
    }
	
}
