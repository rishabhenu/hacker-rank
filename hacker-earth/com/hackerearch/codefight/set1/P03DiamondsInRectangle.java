package com.hackerearch.codefight.set1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Rishabh Sharma
 * 
 *         We are given H and W of rectangle. We need to find the number of
 *         diamonds that can be placed inside that rectangle.
 * 
 *         Diamond is in the shape of parallelogram whose perpendicular sides
 *         having measurements 4*2.
 * 
 *         find the area of rectangle which is unoccupied <br/>
 *         
 *         *****2****		<br/>
 *         *	*			<br/>
 *         *   * *			<br/>
 *         *  *   *			<br/>
 *         4 *     *		<br/>
 *         *  *   *			<br/>
 *         *   * *			<br/>
 *         *    *			<br/>
 *         
 *         diamond shape and size will be like this
 *         
 */
public class P03DiamondsInRectangle {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = new Integer(br.readLine());

		for (int i = 0; i < testCases; i++) {
			String input[] = br.readLine().split(" ");
			long h = new Long(input[0]);
			long w = new Long(input[1]);
			long widthDiamonds = w / 2L;
			long heightDiamonds = h / 4L;
			long totalDiamonds = (widthDiamonds * heightDiamonds);
			System.out.println(totalDiamonds);
			totalDiamonds += ((widthDiamonds - 1L) * (heightDiamonds - 1L));
			System.out.println(totalDiamonds);
			if (h % 4L >= 2L && w % 2 < 1) {
				System.out.println("first if");
				totalDiamonds += widthDiamonds - 1L;
			}
			System.out.println(totalDiamonds);
			if (w % 2 >= 1 && h % 4L < 2L) {
				System.out.println("second if");
				totalDiamonds += heightDiamonds - 1L;
			}
			
			if(w % 2 >= 1 && h % 4L >= 2L) {
				totalDiamonds += (heightDiamonds*widthDiamonds);
			}
			System.out.println(totalDiamonds);
			long totalArea = w * h;
			long diamonArea = totalDiamonds * 4;

			System.out.println(totalArea - diamonArea);
		}
	}
}
