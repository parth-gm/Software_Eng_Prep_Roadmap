package dp;

import java.util.Arrays;
import java.util.Scanner;

public class BitonicSequence {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int ntests = sc.nextInt();
		
		while(ntests-->0) {
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
			}
			System.out.println(getLBS(arr, n));	
		}	
	}
	//15 20 20 6 4 2
	//[1, 2, 2, 3, ]
	static int getLBS(int[] input, int n) {
	
		int[] outputL = new int[n];
		outputL[0]=1;
		int ansLeft=0;
		for(int i=1;i<n;i++) {
			outputL[i]=1;
			for(int j=i-1;j>=0;j--){
				
				if(input[j]>input[i])
					continue;
				
				int possibleAns = outputL[j]+1; 
				if(possibleAns>outputL[i]) {
					outputL[i] = possibleAns;
				}
				
			}
			
		}
		
		int[] outputR = new int[n];
		
		outputR[n-1]=1;
		int ansRight=0;
		for(int i=n-2;i>=0;i--) {
			outputR[i]=1;
			for(int j=i+1;j<n;j++){
				
				if(input[j]>input[i])
					continue;
				
				int possibleAns = outputR[j]+1; 
				if(possibleAns>outputR[i]) {
					outputR[i] = possibleAns;
				}	
			}
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			ans = Math.max(outputL[i]+outputR[i]-1, ans);
		}
		return ans;
	}

}
