package com.geeksforgreeks.codingpractise.program1;

class GfG {
	public static int findMax(Height arr[], int n) {
		int maxHeight = 0;
		for(int i=0;i<n;i++){
			int height = arr[i].inches + (arr[i].feet*12);
			if(height>=maxHeight) maxHeight = height;
		}
		return maxHeight;
	}

}