package com.hackerrank.programs;

public class P10BeautifulString {
	
	public static void main(String...strings) {
		String b = "0100101010100010110100100110110100011100111110101001011001110111110000101011011111011001111100011101";
		String c = b.replaceAll("010", "A");
		System.out.println(b.replaceAll("010", "A"));
		if(b.contains("010")) {
			System.out.println("contained "+b.indexOf("010"));
		}
		int count = 0;
        while(b.contains("010")){
        	count++;
            if(b.contains("010")){
//                count++;
                b = b.replaceFirst("010","A");
                System.out.println(b+", "+count);
            }
        }
        System.out.println(count);
        System.out.println(c);
        System.out.println(b.equalsIgnoreCase(c));
	}
}
