package com.hackerrank.programs.set1;

import java.io.IOException;
import java.util.Scanner;

public class P02BiggerIsGreater {

	// Complete the biggerIsGreater function below.
	static String biggerIsGreater(String w) {
        String s = "no result";
		for(int i=w.length()-1;i>0;i--) {
        	if(w.charAt(i) > w.charAt(i-1)) {
        		System.out.println(w.substring(0,i-1)+", "+w.charAt(i)+", "+w.charAt(i-1)+", "+w.substring(i));
        		s = w.substring(0, i-1)+w.charAt(i)+w.charAt(i-1)+w.substring(i+1,w.length());
        	}
        }
		System.out.println("returning "+s);
        return s;
    }

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		String s = "ab";
		System.out.println(biggerIsGreater(s));
	}
}
