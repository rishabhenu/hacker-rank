package com.hackerrank.programs.set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author rishabhenu@gmail.com
 * @source https://www.hackerrank.com/challenges/matrix-rotation-algo/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class P03MatrixLayerRotation {
	private static Logger logger = Logger.getLogger(P3MatrixLayerRotation.class.getName());
	public static void main(String...strings) {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>(); 
		List<Integer> row = null;
		row = Arrays.asList(3,4,5);
		matrix.add(row);
		row = Arrays.asList(7,8,9);
		matrix.add(row);
		row = Arrays.asList(11,22,33);
		matrix.add(row);
//		row = Arrays.asList(12,23,34);
//		matrix.add(row);
		System.out.println();
		logger.info("******************************************Starting***********************************************");
		StringBuilder sb = new StringBuilder(" input is >>>>>>>>>>>>>>> ");
		for(List<Integer> list : matrix) {
			sb.append("\n"+list.toString());
		}
		int r = 3;
		sb.append("\ncalling matrixRotation function with above matrix with r="+r);
		logger.info(sb.toString());
		matrixRotation(matrix, r);
	}
	
	static void matrixRotation(List<List<Integer>> matrix, int r) {
		int startRow = 0, endRow = matrix.size(), startColumn = 0, endColumn = matrix.get(0).size();
		int[][] resultArray = new int[endRow][endColumn];
		while(startRow<endRow || startColumn<endColumn) {
			logger.info("==============startRow="+startRow+", endRow="+endRow+", startColumn="+startColumn+", endColumn="+endColumn);
			resultArray = doCompleteProcess(matrix,r,resultArray,startRow,endRow,startColumn,endColumn);
			startRow++;endRow--;startColumn++;endColumn--;
		}
		for(int i=0; i<matrix.size(); i++) {
			for(int j=0; j<matrix.get(0).size(); j++) {
				System.out.print(resultArray[i][j]+" ");
			}
			System.out.println();
		}
    }
	
	private static int[][] doCompleteProcess(List<List<Integer>> matrix, int r , int[][] resultArray, int startRow, int endRow, int startColumn, int endColumn){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=startColumn; i<endColumn; i++) {
			list.add(matrix.get(startRow).get(i));
		}
		logger.info("firstLoop list is "+list);
		for(int i=startRow+1; i<endRow; i++) {
			list.add(matrix.get(i).get(endColumn-1));
		}
		logger.info("secondLoop list is "+list);
		if(Math.abs(startRow-endRow)!=1)
		for(int i=endColumn-2; i>=startColumn; i--) {
			list.add(matrix.get(endRow-1).get(i));
		}
		logger.info("thirdLoop list is "+list);
		for(int i=endRow-2; i>startRow; i--) {
			list.add(matrix.get(i).get(startRow));
		}
		logger.info("finalLoop list is "+list);
		list = rotateList(list,r);
		
		int indexOfList = 0;
		for(int i=startColumn; i<endColumn; i++) {
			resultArray[startRow][i] = list.get(indexOfList);
			indexOfList++;
		}
		for(int i=startRow+1; i<endRow; i++) {
			resultArray[i][endColumn-1] = list.get(indexOfList);
			indexOfList++;
		}
		if(Math.abs(startRow-endRow)!=1)
		for(int i=endColumn-2; i>=startColumn; i--) {
			resultArray[endRow-1][i] = list.get(indexOfList);
			indexOfList++;
		}
		for(int i=endRow-2; i>startRow; i--) {
			resultArray[i][startRow] = list.get(indexOfList);
			indexOfList++;
		}
		return resultArray;
	}
	
	private static List<Integer> rotateList(List<Integer> list, int noOfTimes){
		StringBuilder sb = new StringBuilder("input for rotateList is >>>>>>>>>>>>\n"+list);
		int count = 0;
		try{
			noOfTimes = noOfTimes%list.size();
		}catch(Exception e) {
			sb.append("\nrotateList loop ran "+count+" times. resulting output list is >>>>>>>>>>>>\n"+list);
			logger.info(sb.toString());
			return list;
		}
		for(int i=1; i<=noOfTimes; i++) {
			count++;
			list = rotateList(list);
		}
		sb.append("\nrotateList loop ran "+count+" times. resulting output list is >>>>>>>>>>>>\n"+list);
		logger.info(sb.toString());
		return list;
	}
	private static List<Integer> rotateList(List<Integer> list){
		int temp = list.get(0);
		boolean b = true;
		List<Integer> resultList = new ArrayList<Integer>();
		for(int i : list) {
			if(b) {
				b = false;
				continue;
			}
			resultList.add(i);
		}
		resultList.add(temp);
		return resultList;
	}
}
