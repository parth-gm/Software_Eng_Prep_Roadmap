package practice;

import java.util.Arrays;


public class CandyDistribution {

	
	static int findMinTotalCandies(int[] arr) {
		
		int dist[]=new int[arr.length];
		Arrays.fill(dist, 1);
		
		if(arr[0]>arr[1]) {
			
			dist[0]=dist[1]+1;
			
		}
		
		for(int i=1;i<arr.length-1;i++) {
			
			if(arr[i]>arr[i-1]) {
				dist[i]=dist[i-1]+1;
			}else if( arr[i]<=arr[i-1]  && arr[i]>arr[i+1]) {
				dist[i]=dist[i+1]+1;
			}
			
		}
		if(arr[arr.length-1]>arr[arr.length-2]) {
			dist[arr.length-1]=dist[arr.length-2]+1;
		}
		
		System.out.println(Arrays.toString(dist));
		int sum=0;
		for(int i=0;i<dist.length;i++) {	
			sum=sum+dist[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {1,2,87,87,87,2,1};
		
		System.out.println(findMinTotalCandies(arr));
		

	}

}
