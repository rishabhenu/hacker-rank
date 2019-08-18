package com.hackerrank.toberemember.challenges;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Rishabh Sharma
 *
 * @source	https://www.hackerrank.com/challenges/decibinary-numbers/problem?h_r=next-challenge&h_v=zen
 * 
 * @result	Only 5/11 test cases passed
 */
public class P006DeciBinaryNumber {
	
	public static void main(String...strings) {
		System.out.println(decibinaryNumbers(100));
		for(Integer key : deciBinaryNumbers.keySet()) {
			System.out.println(key+" : "+deciBinaryNumbers.get(key));
		}
	}
	
	private static List<Integer> deciBinaryList = new ArrayList<>();
	private static long limit;
	private static void createDeciBinaryList(long numLimit) {
		while(limit <= numLimit) {
			Set<Long> set = getAllBinaryNumbers(deciBinaryNumbers.size());
			deciBinaryNumbers.put(deciBinaryNumbers.size(), set);
			limit += set.size();
			deciBinaryList.add(set.size());
		}
	}
	
	private static Set<Long> getAllBinaryNumbers(int decimalNumber) {
		Set<Long> set = new TreeSet<>();
		if(decimalNumber<10)set.add((long)decimalNumber);
		int i;
		for(i=1; decimalNumber > Math.pow(2, i); i++) {
			for(int j=1; decimalNumber >= j*(Math.pow(2, i)); j++) {
				int key = j * (int)Math.pow(2, i);
				for(Long l : deciBinaryNumbers.get(decimalNumber-key)) {
					if(l.toString().length() < i) {
						int zeros = i-l.toString().length();
						String s = (int)(j*Math.pow(10, zeros))+""+l;
						set.add(new Long(s));
					} else if(l.toString().length() == i) {
						set.add(new Long(j+""+l));
					}else {
						break;
					}
				}
			}
		}
		set.add(Long.parseLong((new BigInteger(""+decimalNumber)).toString(2)));
		return set;
	}

	private static Map<Integer, Set<Long>> deciBinaryNumbers = new HashMap<>();
	static {
		Set<Long> set = new TreeSet<Long>();
		set.add(0L);
		limit+=set.size();
		deciBinaryNumbers.put(0, set);
		deciBinaryList.add(set.size());
		set = new TreeSet<Long>();
		set.add(1l);
		limit+=set.size();
		deciBinaryNumbers.put(1, set);
		deciBinaryList.add(set.size());
		set = new TreeSet<Long>();
		set.add(2l);set.add(10l);
		limit+=set.size();
		deciBinaryNumbers.put(2, set);
		deciBinaryList.add(set.size());
		set = new TreeSet<Long>();
		set.add(3l);set.add(11l);
		limit+=set.size();
		deciBinaryNumbers.put(3, set);
		deciBinaryList.add(set.size());
	}
	
	static long decibinaryNumbers(long x) {
		if(limit < x) {
			createDeciBinaryList(x);
		}
		long result=0l;
		long sum=0;
		for(int i=0; i<deciBinaryList.size(); i++) {
			sum += deciBinaryNumbers.get(i).size();
			if(sum >= x) {
				sum  -= deciBinaryNumbers.get(i).size();
				int j=0;
				for(Long l : deciBinaryNumbers.get(i)) {
					j++;
					if(j == (x-sum)) {
						return l;
					}
				}
			}
		}
		return result;
    }

}
