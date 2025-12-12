package dp;

import java.util.Arrays;
import java.util.Scanner;

public class LootHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			
		}
		if(n==0) {
			System.out.println(0);
			return;
		}
		else if(n==1)
		{
			System.out.println(arr[0]);
			return;
		}else if(n==2) {
			System.out.println(Math.max(arr[0], arr[1]));
			return;
		}else if(n==3) {
			System.out.println(Math.max(arr[1], arr[0]+arr[2]));
			return;
		}
		
		
		long[] output = new long[n];
		output[0] = arr[0];
		output[1] = arr[1];
		output[2] = arr[0]+arr[2];
		long ans = Long.MIN_VALUE;
		for(int i=3;i<n;i++) {
			
			output[i]= arr[i] + Math.max(output[i-2], output[i-3]);
			ans = Math.max(ans, output[i]);
			
			
		}
//		System.out.println(Arrays.toString(output));
		System.out.println(ans);
		
	}

}
