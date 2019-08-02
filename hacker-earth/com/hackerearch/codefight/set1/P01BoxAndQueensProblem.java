package com.hackerearch.codefight.set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 
 * @author Rishabh Sharma
 *
 * @input <br/>
 * 		line 1 = no of test cases n <br/>
 * 		Each of next n lines will contain n, m, a, b, c which indicates following <br/>
 * 		n = no of type a queens <br/>
 * 		m = no of type b queens <br/>
 * 		a = score if we place type a queen in type a box only <br/>
 * 		b = score if we place type b queen in type b box only <br/>
 * 		c = score in all other cases than placing same queen in same type of box <br/>
 * 
 * @example take only one test case
 * 		2 3 4 5 6	output would be	29 <br/>
 * @explanation <br/>
 * 		if we place all same queens in same type of boxes we will get, 2*4 + 3*5 = 23 <br/>
 * 		but if we place type a in type b boxes and type b in type a boxes then we will get
 * 		2*6 + (2*6 + 1*5) = 29
 * 
 * @assume there are exactly equal no of boxes of each type than no of queens for example in above case, there are exactly 2 boxes of <br/>
 * 		type a and 3 boxes of type b
 */
public class P01BoxAndQueensProblem {
	
	public static void main(String...strings) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = new Integer(br.readLine());                // Reading input from STDIN
        
        for(int i=0; i<testCases; i++){
            String[] input = br.readLine().split(" ");
            BigInteger
                m = new BigInteger(input[0]),
                n = new BigInteger(input[1]),
                a = new BigInteger(input[2]),
                b = new BigInteger(input[3]),
                c = new BigInteger(input[4]);
            
            BigInteger score1 = null, score2 = null;
            if(n.compareTo(m)>0) {
            	//n is greater
            	score1 = m.multiply(c).multiply(new BigInteger("2"));
            	score1 = score1.add(n.subtract(m).multiply(b));
            }else if(n.compareTo(m)<0) {
            	//m is greater
            	score1 = n.multiply(c).multiply(new BigInteger("2"));
            	score1 = score1.add(m.subtract(n).multiply(a));
            }else {
            	score1 = n.add(m).multiply(c);
            }
            score2 = m.multiply(a).add(n.multiply(b));
            System.out.println((score1.compareTo(score2)>1)?score1:score1);
        }
	}
}
