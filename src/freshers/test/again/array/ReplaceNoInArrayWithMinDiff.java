package freshers.test.again.array;
/**
 * 
 * @author Rishabh.Sharma@openlane.com
 *
 *	You are given an array, You are supposed to replace each no of array with the nearest greater number which will come next to it,
 *	If there's no such number on the right of that number, replace it with -1.
 */
public class ReplaceNoInArrayWithMinDiff {
	
	public static void main(String[] args){
		
		int arr[] = new int[]{5, 3, 10, 8, 15, 12, 20, 12, 25};		
		   //expected output [8, 8, 12, 12, 20, 20, 25, 25, -1]
		
		for(int i=0; i<arr.length; i++){
			if(i == arr.length-1){
				arr[i] = -1;break;
			}
			int curElement = -1;
			int diff = Integer.MAX_VALUE;
			J:for(int j=i+1; j<arr.length; j++){
				int temp = 0;
				if(arr[i] >= arr[j]){
					continue J;
				}
				temp = arr[j] - arr[i];  //temp = 5, 3, 10
				if(diff >= temp){
					diff = temp;	//diff = 5, 3, 
					curElement = arr[j];	//curElement = 10, 8, 
				}
			}
			System.out.println("for i="+i+", curElement="+curElement);
			arr[i] = curElement;
		}
		for(int i : arr){
			System.out.println(i);
		}
	}

}
