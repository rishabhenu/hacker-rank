package com.hackerrank.programs.set1;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/taum-and-bday/problem?h_r=next-challenge&h_v=zen
 * 
 * @result passed all test cases in third attempt
 *
 */

public class P14TaumAndBday {

	static int b, w, bc, wc, z, array[][];

	public static void main(String... strings) {
//		array = new int[][] { { 10, 10, 1, 1, 1 }, { 5, 9, 2, 3, 4 }, { 3, 6, 9, 1, 1 }, { 7, 7, 4, 2, 1 },
//				{ 3, 3, 1, 9, 2 } }; // expected {20,37,12,35,12}
//		for (int i = 0; i < array.length; i++) {
//			taumBday(array[i]);
//		}
		array = new int[][] { { 27984, 1402, 619246, 615589, 247954 }, { 95677, 39394, 86983, 311224, 588538 },
				{ 68406, 12718, 532909, 315341, 201009 }, { 15242, 95521, 712721, 628729, 396706 },
				{ 21988, 67781, 645748, 353796, 333199 }, { 22952, 80129, 502975, 175136, 340236 },
				{ 38577, 3120, 541637, 657823, 735060 }, { 5943, 69851, 674453, 392925, 381074 },
				{ 62990, 61330, 310144, 312251, 93023 }, { 11152, 43844, 788543, 223872, 972572 } };
		for (int i = 0; i < array.length; i++) { // {18192035842,20582630747,39331944938,70920116291,38179353700,25577754744,22947138309,31454478354,38686324390,18609275504}
			taumBday(array[i]);
		}
		b = 27984; w = 1402; bc = 619246; wc = 615589;
		System.out.println((b * bc));
		System.out.println((w * wc));
		System.out.println((b * bc) + (w * wc));
	}

	private static void taumBday(int a[]) {
		int b = a[0], w = a[1], bc = a[2], wc = a[3], z = a[4];
		System.out.println(taumBday(b, w, bc, wc, z));
	}

	private static long taumBday(int b, int w, int bc, int wc, int z) {
		long result = 0;
		if (bc > wc && bc >= wc + z) {
			System.out.print("if\t");
			result = ((long)(b + w) * (long)wc) + ((long)b * (long)z);
		} else if (wc > bc && wc >= bc + z) {
			System.out.print("elseif\t");
			result =  ((long)(b + w) * (long)bc) + ((long)w * (long)z);
		} else{
			System.out.print("else\t");
			result = ((long)b * (long)bc) + ((long)w * (long)wc);
		}
		return result;
	}

}
