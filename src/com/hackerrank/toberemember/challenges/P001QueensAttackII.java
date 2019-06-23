package com.hackerrank.toberemember.challenges;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/queens-attack-2/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
 * 
 * @result timeout error for one method.
 * @result wrote one more method where all test cases passed
 *
 */

public class P001QueensAttackII {
	
	public static void main(String...strings) throws Exception{
		int n = 100;//1;	//4;	//5;
		int k = 100;	//3;
		int[][] obstacles = new int[][]{{54,87},{64,97},{42,75},{32,65},{42,87},{32,97},{54,75},{64,65},{48,87},{48,75},{54,81},{42,81},{45,17},
										{14,24},{35,15},{95,64},{63,87},{25,72},{71,38},{96,97},{16,30},{60,34},{31,67},{26,82},{20,93},{81,38},
										{51,94},{75,41},{79,84},{79,65},{76,80},{52,87},{81,54},{89,52},{20,31},{10,41},{32,73},{83,98},{87,61},
										{82,52},{80,64},{82,46},{49,21},{73,86},{37,70},{43,12},{94,28},{10,93},{52,25},{50,61},{52,68},{52,23},
										{60,91},{79,17},{93,82},{12,18},{75,64},{69,69},{94,74},{61,61},{46,57},{67,45},{96,64},{83,89},{58,87},
										{76,53},{79,21},{94,70},{16,10},{50,82},{92,20},{40,51},{49,28},{51,82},{35,16},{15,86},{78,89},{41,98},
										{70,46},{79,79},{24,40},{91,13},{59,73},{35,32},{40,31},{14,31},{71,35},{96,18},{27,39},{28,38},{41,36},
										{31,63},{52,48},{81,25},{49,90},{32,65},{25,45},{63,94},{89,50},{43,41}};		//expected 10
		int r_q = 48,//4187,	//4,	//4,
				c_q = 81;//5068;	//4;	//3;
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		System.out.println("\nresult is "+result);
	}
	
	private static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		int attacks = 0;
		int[] vertical = new int[]{0,n+1};
		int[] horizontal = new int[]{0,n+1};
		int[] rightUp = new int[]{c_q-Integer.min(r_q, c_q),c_q+n-Integer.max(r_q, c_q)+1};
		int[] rightDown = new int[2];
		int maxColumn = c_q + n-Integer.max(r_q, c_q)+1;System.out.println(maxColumn);
		int minColumn = c_q - (n-Integer.min(c_q, r_q))-1;System.out.println(minColumn);
		rightDown[0] = minColumn; rightDown[1] = maxColumn;
		System.out.println(Arrays.toString(vertical)+", "+Arrays.toString(horizontal)+", "+Arrays.toString(rightUp)+", "+Arrays.toString(rightDown));
		// for straight lines
		for(int i=0; i<k; i++){
			if(obstacles[i][1] == c_q){
				if(obstacles[i][0] < r_q) vertical[0] = Integer.max(vertical[0], obstacles[i][0]);
				else vertical[1] = Integer.min(vertical[1], obstacles[i][0]);
			}
			if(obstacles[i][0] == r_q){
				if(obstacles[i][1] < c_q) horizontal[0] = Integer.max(horizontal[0], obstacles[i][1]);
				else horizontal[1] = Integer.min(horizontal[1], obstacles[i][1]);
			}
			if(obstacles[i][0]-r_q == obstacles[i][1]-c_q){
//				System.out.println("upside right");
				int diff = obstacles[i][0]-r_q;
				if(diff < 0) rightUp[0] = Integer.max(rightUp[0], obstacles[i][1]);
				else rightUp[1] = Integer.min(rightUp[1], obstacles[i][1]);
			}
			if(obstacles[i][0]-r_q == c_q-obstacles[i][1]){
				int diff = obstacles[i][0]-r_q;
				if(diff > 0) rightDown[0] = Integer.max(rightDown[0], obstacles[i][1]);
				else rightDown[1] = Integer.min(rightDown[1], obstacles[i][1]);
				System.out.println("right down "+Arrays.toString(obstacles[i])+", "+Arrays.toString(rightDown));
			}
		}
		System.out.println(Arrays.toString(vertical)+"\n"+Arrays.toString(horizontal)+"\n"+Arrays.toString(rightUp)+"\n"+Arrays.toString(rightDown));
		attacks += vertical[1]-vertical[0]-2;
		attacks += horizontal[1]-horizontal[0]-2;
		attacks += rightUp[1]-rightUp[0]-2;
		attacks += rightDown[1]-rightDown[0]-2;
		return attacks;
	}

	/**
	 * 
	 * @param n
	 * @param k
	 * @param r_q
	 * @param c_q
	 * @param obstacles
	 * @return
	 * @throws IOException. this method is not passed,, some test cases failed due to timeout error
	 */
	static int queensAttackTimeOutFailure(int n, int k, int r_q, int c_q, int[][] obstacles) throws IOException {
		String obstaclesString = ",";
		for(int i=0;;i++){
			try{
				obstaclesString += obstacles[i][0]+""+obstacles[i][1]+",";
			}catch(ArrayIndexOutOfBoundsException e){
				break;
			}
		}
		
//		try{
//			obstaclesString = new BufferedReader(new FileReader("D://new.txt")).readLine();
//		}catch(Exception e){}
		System.out.println(obstaclesString);
		int attacks = 0;
		
		/**
		 * up down right left upRight upLeft downRight downLeft
		 * 
		 */
		boolean[] dirBlocked = new boolean[8];
		int[] dr = new int[]{r_q, r_q, c_q, c_q, r_q, c_q, r_q, c_q, r_q, c_q, r_q, c_q};
		System.out.println(Arrays.toString(dr));
		File file = new File("D://result.txt");
		FileWriter fr = new FileWriter(file);
		fr.write("");
		for(int row=1; row <= n; row++){
			System.out.print(row+" : ");
			dr[0]++;					//going up
			if(!dirBlocked[0] && dr[0] <= n && !obstaclesString.contains(","+dr[0]+""+c_q+",")) attacks++;
			else {dirBlocked[0] = true;}
			System.out.print(attacks+" ");
			dr[1]--;					//going down
			if(!dirBlocked[1] && dr[1] > 0 && !obstaclesString.contains(","+dr[1]+""+c_q+",")) attacks++;
			else {dirBlocked[1] = true;}
			System.out.print(attacks+" ");
			dr[2]++;					//going right
			if(!dirBlocked[2] && dr[2] <= n && !obstaclesString.contains(","+r_q+""+dr[2]+",")) attacks++;
			else {dirBlocked[2] = true;}
			System.out.print(attacks+" ");
			dr[3]--;					//going left
			if(!dirBlocked[3] && dr[3] > 0 && !obstaclesString.contains(","+r_q+""+dr[3]+",")) attacks++;
			else {dirBlocked[3] = true;}
			System.out.print(attacks+" ");
			dr[4]++;	dr[5]++;		//going Up-Right
			if(!dirBlocked[4] && dr[4] <= n && dr[5] <= n && !obstaclesString.contains(","+dr[4]+""+dr[5]+",")) attacks++;
			else {dirBlocked[4] = true;}
			System.out.print(attacks+" ");
			dr[6]++;	dr[7]--;		//going Up-Left
			if(!dirBlocked[5] && dr[6] <= n && dr[7] > 0 && !obstaclesString.contains(","+dr[6]+""+dr[7]+",")) attacks++;
			else {dirBlocked[5] = true;}
			System.out.print(attacks+" ");
			dr[8]--;	dr[9]++;		//going Down-Right
			if(!dirBlocked[6] && dr[8] > 0 && dr[9] <= n && !obstaclesString.contains(","+dr[8]+""+dr[9]+",")) attacks++;
			else {dirBlocked[6] = true;}
			System.out.print(attacks+" ");
			dr[10]--;	dr[11]--;		//going Down-Left
			if(!dirBlocked[7] && dr[10] > 0 && dr[11] > 0 && !obstaclesString.contains(","+dr[10]+""+dr[11]+",")) attacks++;
			else {dirBlocked[7] = true;}
			System.out.print(attacks+"\n");
			fr.write(row+"\t:-\t"+Arrays.toString(dirBlocked)+",\t"+Arrays.toString(dr)+"\n");
		}
		fr.flush();
		fr.close();
		return attacks;
    }

}
