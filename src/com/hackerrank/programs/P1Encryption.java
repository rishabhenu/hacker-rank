package com.hackerrank.programs;

import java.io.IOException;
import java.util.Scanner;

public class P1Encryption {

	// Complete the encryption function below.
	static String encryption(String s) {
        double rows = 0, columns = 0;
        s=s.replaceAll("\\s", "");
        System.out.println("given input is after replacing spaces "+s);
        rows = Math.floor(Math.sqrt(s.length()));
        columns = Math.ceil(Math.sqrt(s.length()));
        if(rows * columns < s.length()) rows+=1;
        System.out.println("rows="+rows+", columns="+columns);
        String result = "";
        for(int i=0;i<columns;i++) {
        	int lastIndex = i;
        	while(lastIndex < s.length()) {
        		result+=s.charAt(lastIndex);
        		lastIndex+=columns;
        	}
        	result+=" ";
        }
        return result;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = encryption(s);
		
		System.out.println(result);

//		bufferedWriter.write(result);
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
