package com.hackerrank.programs;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/separate-the-numbers/problem?h_r=next-challenge&h_v=zen
 * @result passed submitted
 *
 */
public class P6SeperateTheNumbers {

	public static void main(String...strings) {
		String s = "9899100101";
		System.out.println("i/p is "+s);
		System.out.print("o/p is ");
		System.out.println(addOneToNumericString(s, s.length()-1));
		separateNumbers(s);
	}
	
	static void separateNumbers(String s) {
		if(!checkFirstTwoNumbers(s, 0, 1, null)) {
			System.out.println("NO");
		}
	}
	
	
	private static boolean checkFirstTwoNumbers(String s, int startIndex, int sizeOfFirst, String fNumber) {
		if(s.charAt(startIndex)=='0' || sizeOfFirst > (s.length()+1)/2 || sizeOfFirst<1) {
//			System.out.println("s.charAt(startIndex)=='0'");
			return false;
		}
		String firstNumber = s.substring(startIndex, (startIndex+sizeOfFirst));
		String secondNumber = addOneToNumericString(firstNumber, firstNumber.length()-1);
		if(sizeOfFirst >= s.length()) {
//			System.out.println("sizeOfFirst >= s.length() for s "+s+", startIndex "+startIndex+", sizeOfFirst "+sizeOfFirst);
			return false;
		}
//		System.out.println(startIndex+secondNumber.length()+", "+s.length());
//		System.out.println("startIndex+secondNumber.length() == s.length() "+(startIndex+secondNumber.length() == s.length()));
		System.out.println(firstNumber+", "+secondNumber);
		if(startIndex+firstNumber.length() == s.length()) {
			if(startIndex!=0 && !s.equalsIgnoreCase(fNumber)) {
				System.out.println("YES "+fNumber);
				return true;
			}
			return false;
		}
		startIndex += sizeOfFirst;
		if(startIndex+secondNumber.length()<=s.length() && secondNumber.equalsIgnoreCase(s.substring(startIndex,startIndex+secondNumber.length()))) {
//			System.out.println("secondNumber.equalsIgnoreCase(s.substring(startIndex,startIndex+secondNumber.length())) for fNum "+firstNumber+", sNum "+secondNumber);
			fNumber = fNumber==null?firstNumber:fNumber;
			return checkFirstTwoNumbers(s, startIndex, secondNumber.length(),fNumber);
		}else {
			return checkFirstTwoNumbers(s, 0, sizeOfFirst+1, null);
		}
	}
	
	private static String addOneToNumericString(String s, int atIndex) {
		if(s.substring(atIndex, atIndex+1).equals("9")) {
			if(atIndex==0 && s.length()==1)return "10";
			if(atIndex==0 && s.length()>1)return "10"+s.substring(1);
			if(atIndex == s.length()-1) {
				return addOneToNumericString(s.substring(0,atIndex)+"0", atIndex-1);
			}else{
				return addOneToNumericString(s.substring(0,atIndex)+"0"+s.substring(atIndex+1), atIndex-1);
			}
		}else {
			int numAtIndex = Integer.parseInt(""+s.charAt(atIndex));
			if(atIndex == s.length()-1) {
				return s.substring(0,atIndex)+(numAtIndex+1);
			}else{
				return s.substring(0,atIndex)+(numAtIndex+1)+s.substring(atIndex+1);
			}
		}
	}
	
}
