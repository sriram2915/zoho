package zoho;

import java.util.*;

public class hello {
	public static void main(String args[]) {
		int[] arr = {9,-4,3,2,-7,8,5};
		
//		int[] arr = {6,1,4,9,2,7};
		
		
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			
			int min = i;
			boolean temp = arr[min] % 2 == 0 ? true : false;
			
			for(int j=i+1;j<n;j++) {
				
				if(temp) {
					if(arr[j]%2==0 && arr[min]<arr[j]) {
						min = j;
					}
				}
				else {
					if(arr[j]%2!=0 && arr[min]>arr[j]) {
						min = j;
					}
				}
			}
			int t = arr[min];
			arr[min] = arr[i];
			arr[i] = t;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	
}
